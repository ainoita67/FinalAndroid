package com.example.finalandroid

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionlista.modelo.Receta
import com.example.finalandroid.datos.RepositorioSingleton
import com.example.finalandroid.modelo.Categoria
import com.example.finalandroid.modelo.Ingrediente
import com.example.finalandroid.modelo.Unidad

class NuevaRecetaActivity : AppCompatActivity() {

    // Aquí se añaden las filas de ingredientes y de pasos
    private lateinit var contenedorIngredientes: LinearLayout
    private lateinit var contenedorPasos: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nueva_receta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Desplegable de categorías: una opción por cada valor del enum
        val categorias = Categoria.entries.map { it.texto }
        findViewById<Spinner>(R.id.spinnerCategoria).adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categorias)

        // Empezamos con una fila vacía de ingrediente y otra de paso
        contenedorIngredientes = findViewById(R.id.contenedorIngredientes)
        contenedorPasos = findViewById(R.id.contenedorPasos)
        anadirFilaIngrediente()
        anadirFilaPaso()

        findViewById<Button>(R.id.botonAnadirIngrediente).setOnClickListener { anadirFilaIngrediente() }
        findViewById<Button>(R.id.botonAnadirPaso).setOnClickListener { anadirFilaPaso() }
        findViewById<Button>(R.id.botonGuardar).setOnClickListener { guardarReceta() }
    }

    private fun anadirFilaIngrediente() {
        val fila = layoutInflater.inflate(R.layout.fila_nuevo_ingrediente, contenedorIngredientes, false)
        // El botón ✕ quita la fila
        fila.findViewById<Button>(R.id.botonQuitarIngrediente).setOnClickListener {
            contenedorIngredientes.removeView(fila)
        }
        contenedorIngredientes.addView(fila)
    }

    private fun anadirFilaPaso() {
        val fila = layoutInflater.inflate(R.layout.fila_nuevo_paso, contenedorPasos, false)
        fila.findViewById<Button>(R.id.botonQuitarPaso).setOnClickListener {
            contenedorPasos.removeView(fila)
        }
        contenedorPasos.addView(fila)
    }

    private fun guardarReceta() {
        val editTitulo = findViewById<EditText>(R.id.editTitulo)
        val editPreparacion = findViewById<EditText>(R.id.editPreparacion)
        val editCoccion = findViewById<EditText>(R.id.editCoccion)
        val editRaciones = findViewById<EditText>(R.id.editRaciones)

        // Leer los campos (toIntOrNull da null si está vacío o no es un número)
        val titulo = editTitulo.text.toString().trim()
        // La posición elegida en el desplegable es la misma que en Categoria.entries
        val categoria = Categoria.entries[findViewById<Spinner>(R.id.spinnerCategoria).selectedItemPosition]
        val preparacion = editPreparacion.text.toString().toIntOrNull()
        val coccion = editCoccion.text.toString().toIntOrNull()
        val raciones = editRaciones.text.toString().toIntOrNull()

        // Si falta algo, se marca el campo y se para aquí
        if (titulo.isEmpty()) {
            editTitulo.error = "Escribe el nombre de la receta"
            editTitulo.requestFocus()
            return
        }
        if (preparacion == null) {
            editPreparacion.error = "Escribe los minutos (puede ser 0)"
            editPreparacion.requestFocus()
            return
        }
        if (coccion == null) {
            editCoccion.error = "Escribe los minutos (puede ser 0)"
            editCoccion.requestFocus()
            return
        }
        if (raciones == null || raciones < 1) {
            editRaciones.error = "Tiene que ser 1 o más"
            editRaciones.requestFocus()
            return
        }

        // Ingredientes: se recorren las filas y se saltan las que no tienen nombre
        val ingredientes = mutableListOf<Ingrediente>()
        for (i in 0 until contenedorIngredientes.childCount) {
            val fila = contenedorIngredientes.getChildAt(i)
            val nombre = fila.findViewById<EditText>(R.id.editNombreIngrediente).text.toString().trim()
            if (nombre.isEmpty()) continue

            // Vale "1,5" y "1.5". Sin cantidad = "al gusto"
            val cantidad = fila.findViewById<EditText>(R.id.editCantidadIngrediente)
                .text.toString().replace(",", ".").toDoubleOrNull()

            // La opción 0 es "al gusto"; las demás van en el orden de Unidad
            val posicion = fila.findViewById<Spinner>(R.id.spinnerUnidad).selectedItemPosition
            val unidad = if (posicion == 0 || cantidad == null) null else Unidad.entries[posicion - 1]

            ingredientes.add(Ingrediente(nombre, cantidad, unidad))
        }

        // Pasos: se guardan los que tienen texto
        val pasos = mutableListOf<String>()
        for (i in 0 until contenedorPasos.childCount) {
            val texto = contenedorPasos.getChildAt(i)
                .findViewById<EditText>(R.id.editPaso).text.toString().trim()
            if (texto.isNotEmpty()) pasos.add(texto)
        }

        if (ingredientes.isEmpty()) {
            Toast.makeText(this, "Añade al menos un ingrediente", Toast.LENGTH_LONG).show()
            return
        }
        if (pasos.isEmpty()) {
            Toast.makeText(this, "Añade al menos un paso", Toast.LENGTH_LONG).show()
            return
        }

        val valoracion = findViewById<RatingBar>(R.id.ratingNueva).rating

        val receta = Receta(
            titulo,
            categoria,
            preparacion,
            coccion,
            raciones,
            ingredientes,
            pasos,
            valoracion
        )
        RepositorioSingleton.instance.listaRecetas.nueva(receta)

        Toast.makeText(this, "Receta guardada", Toast.LENGTH_SHORT).show()
        finish()  // vuelve a la lista
    }
}

package com.example.finalandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalandroid.datos.RepositorioSingleton

class RecetaActivity : AppCompatActivity() {

    companion object {
        const val NUMERO_RECETA = "idReceta"
    }

    // Posición del paso que se está mostrando (0 = primer paso)
    private var pasoActual = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idReceta = intent.extras?.getInt(NUMERO_RECETA) ?:0
        enableEdgeToEdge()
        setContentView(R.layout.activity_receta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lista = RepositorioSingleton.instance.listaRecetas
        val receta = lista.buscar(idReceta)

        val pasos = receta.instrucciones


        findViewById<TextView>(R.id.textTitulo).text = receta.titulo
        findViewById<TextView>(R.id.textCategoria).text = receta.categoria.texto
        findViewById<TextView>(R.id.textPreparacion).text = "${receta.tiempoPreparacion} m"
        findViewById<TextView>(R.id.textCoccion).text = "${receta.tiempoCoccion} m"
        findViewById<TextView>(R.id.textRaciones).text = receta.racionesTexto()
        findViewById<RatingBar>(R.id.ratingBar).rating = receta.valoracio

        val icono = findViewById<ImageView>(R.id.icono)
        val draw = AppCompatResources.getDrawable(this, receta.categoria.imagen)
        icono.setImageDrawable(draw)

        // --- Ingredientes: una fila por cada ingrediente ---
        val listaIngredientes = findViewById<LinearLayout>(R.id.listaIngredientes)
        for (ingrediente in receta.ingredientes) {
            // Creamos una fila nueva a partir de fila_ingrediente.xml
            val fila = layoutInflater.inflate(R.layout.fila_ingrediente, listaIngredientes, false)
            fila.findViewById<TextView>(R.id.textNombreIngrediente).text = ingrediente.nombre
            // cantidadTexto() junta número y unidad, por ejemplo "200 g" o "Al gusto"
            fila.findViewById<TextView>(R.id.textCantidadIngrediente).text = ingrediente.cantidadTexto()
            // La añadimos al contenedor para que se vea en pantalla
            listaIngredientes.addView(fila)
        }

        // --- Instrucciones: un paso cada vez ---
        val textNumeroPaso = findViewById<TextView>(R.id.textNumeroPaso)
        val textPaso = findViewById<TextView>(R.id.textPaso)
        val botonAnterior = findViewById<Button>(R.id.botonAnterior)
        val botonSiguiente = findViewById<Button>(R.id.botonSiguiente)

        // Pinta en pantalla el paso que indica pasoActual
        fun mostrarPaso() {
            if (pasos.isEmpty()) {
                textNumeroPaso.text = "Sin instrucciones"
                textPaso.text = ""
                botonAnterior.visibility = View.INVISIBLE
                botonSiguiente.visibility = View.INVISIBLE
                return
            }
            textNumeroPaso.text = "Paso ${pasoActual + 1} de ${pasos.size}"
            textPaso.text = pasos[pasoActual]
            // En el primer paso no hay "anterior"; en el último no hay "siguiente"
            botonAnterior.visibility = if (pasoActual > 0) View.VISIBLE else View.INVISIBLE
            botonSiguiente.visibility = if (pasoActual < pasos.size - 1) View.VISIBLE else View.INVISIBLE
        }

        botonAnterior.setOnClickListener {
            if (pasoActual > 0) {
                pasoActual--
                mostrarPaso()
            }
        }

        botonSiguiente.setOnClickListener {
            if (pasoActual < pasos.size - 1) {
                pasoActual++
                mostrarPaso()
            }
        }

        mostrarPaso()

        // --- Eliminar receta: primero se pide confirmación ---
        findViewById<Button>(R.id.botonEliminar).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Eliminar receta")
                .setMessage("¿Seguro que quieres eliminar \"${receta.titulo}\"? No se puede deshacer.")
                .setPositiveButton("Eliminar") { _, _ ->
                    lista.borrar(idReceta)
                    Toast.makeText(this, "Receta eliminada", Toast.LENGTH_SHORT).show()
                    finish()  // vuelve a la lista
                }
                .setNegativeButton("Cancelar", null)  // null = solo cierra el diálogo
                .show()
        }
    }
}


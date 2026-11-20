package com.example.finalandroid

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalandroid.modelo.TipoDado
import kotlin.random.Random

class DadosActivity : AppCompatActivity() {
    private val minDados = 1
    private val maxDados = 20
    private var cantidad = 1

    private lateinit var textoCantidad: TextView
    private lateinit var spinnerTipo: Spinner
    private lateinit var layoutDados: LinearLayout
    private lateinit var textoSuma: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textoCantidad = findViewById(R.id.textoCantidad)
        spinnerTipo = findViewById(R.id.spinnerTipoDado)
        layoutDados = findViewById(R.id.DadosLayout)
        textoSuma = findViewById(R.id.textoSuma)

        // Desplegable con los tipos de dado; empieza en d6
        spinnerTipo.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, TipoDado.entries)
        spinnerTipo.setSelection(TipoDado.D6.ordinal)

        findViewById<Button>(R.id.botonMenos).setOnClickListener { cambiarCantidad(-1) }
        findViewById<Button>(R.id.botonMas).setOnClickListener { cambiarCantidad(+1) }
        findViewById<Button>(R.id.botonLanzar).setOnClickListener { lanzar() }
    }

    // Suma o resta un dado sin salirse de los límites
    private fun cambiarCantidad(cambio: Int) {
        cantidad = (cantidad + cambio).coerceIn(minDados, maxDados)
        textoCantidad.text = cantidad.toString()
    }

    private fun lanzar() {
        val tipo = TipoDado.entries[spinnerTipo.selectedItemPosition]
        // Un número al azar entre 1 y las caras del dado, una vez por cada dado
        val resultados = List(cantidad) { Random.nextInt(1, tipo.caras + 1) }

        // Borramos los dados de la tirada anterior
        layoutDados.removeAllViews()

        val tamano = (56 * resources.displayMetrics.density).toInt()  // 56dp en píxeles
        val margen = (4 * resources.displayMetrics.density).toInt()   // 4dp en píxeles
        var fila = LinearLayout(this)

        for (i in resultados.indices) {
            // Cada 5 dados empezamos una fila nueva
            if (i % 5 == 0) {
                fila = LinearLayout(this)
                fila.orientation = LinearLayout.HORIZONTAL
                layoutDados.addView(fila)
            }

            // Un cuadrado con el número del dado
            // le damos la estetica aquí porque no existe en el xml hasta que se crea aqui
            // con plantillas como en la lista de recetas se puede hacer pero no hace falta
            val cuadrado = TextView(this)
            cuadrado.text = resultados[i].toString()
            cuadrado.gravity = Gravity.CENTER
            cuadrado.textSize = 22f
            cuadrado.typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
            cuadrado.setTextColor(ContextCompat.getColor(this, R.color.petroleo))
            cuadrado.setBackgroundColor(ContextCompat.getColor(this, R.color.mostaza))

            val parametros = LinearLayout.LayoutParams(tamano, tamano)
            parametros.setMargins(margen, margen, margen, margen)
            cuadrado.layoutParams = parametros

            fila.addView(cuadrado)
        }

        textoSuma.text = "Suma: ${resultados.sum()}"
    }
}

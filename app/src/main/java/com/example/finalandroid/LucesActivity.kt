package com.example.finalandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class LucesActivity : AppCompatActivity() {
    private val tamano = 5

    private val luces = Array(tamano) { IntArray(tamano) }

    private val ids = arrayOf(
        intArrayOf(R.id.l11, R.id.l12, R.id.l13, R.id.l14, R.id.l15),
        intArrayOf(R.id.l21, R.id.l22, R.id.l23, R.id.l24, R.id.l25),
        intArrayOf(R.id.l31, R.id.l32, R.id.l33, R.id.l34, R.id.l35),
        intArrayOf(R.id.l41, R.id.l42, R.id.l43, R.id.l44, R.id.l45),
        intArrayOf(R.id.l51, R.id.l52, R.id.l53, R.id.l54, R.id.l55)
    )

    // Los TextView de la cuadrícula
    private lateinit var casillas: Array<Array<TextView>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_luces)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //guardar los text view en casillas a partir de los ids ahora que ya existen en el layout
        casillas = Array(tamano) { fila ->
            Array(tamano) { columna -> findViewById<TextView>(ids[fila][columna]) }
        }

        // añadir el listener a cada casilla
        for (fila in 0 until tamano) {
            for (columna in 0 until tamano) {
                casillas[fila][columna].setOnClickListener { pulsar(fila, columna) }
            }
        }

        findViewById<Button>(R.id.botonNuevaPartida).setOnClickListener { nuevaPartida() }

        nuevaPartida()
    }

    // Empezamos con todo apagado y "pulsamos" casillas al azar.
    // Así el tablero siempre tiene solución (si pusiéramos 0 y 1 al azar,
    // muchas veces sería imposible de resolver).
    private fun nuevaPartida() {
        for (fila in 0 until tamano) {
            for (columna in 0 until tamano) {
                luces[fila][columna] = 0
            }
        }
        for (i in 1..5)
        {
            cambiarCruz(Random.nextInt(tamano), Random.nextInt(tamano))
        }

        actualizarPantalla()
    }

    private fun pulsar(fila: Int, columna: Int) {
        cambiarCruz(fila, columna)
        actualizarPantalla()

        if (todasApagadas()) {
            Toast.makeText(this, "¡Has ganado!", Toast.LENGTH_LONG).show()
        }
    }

    // Cambia la casilla pulsada y las 4 de alrededor (arriba, abajo, izquierda, derecha)
    private fun cambiarCruz(fila: Int, columna: Int) {
        cambiar(fila, columna)
        cambiar(fila - 1, columna)
        cambiar(fila + 1, columna)
        cambiar(fila, columna - 1)
        cambiar(fila, columna + 1)
    }

    private fun cambiar(fila: Int, columna: Int) {
        if (fila in 0 until tamano && columna in 0 until tamano) {
            if(luces[fila][columna] == 0){
                luces[fila][columna] = 1
            } else {
                luces[fila][columna] = 0
            }
        }
    }

    private fun todasApagadas(): Boolean {
        for (fila in luces) {
            for (luz in fila) {
                if (luz == 1) return false
            }
        }
        return true
    }

    // Copia la matriz a la pantalla: número y color de cada casilla
    private fun actualizarPantalla() {
        val colorEncendida = ContextCompat.getColor(this, R.color.mostaza)
        val colorApagada = ContextCompat.getColor(this, R.color.verde)
        val textoEncendida = ContextCompat.getColor(this, R.color.petroleo)
        val textoApagada = ContextCompat.getColor(this, R.color.crema)

        for (fila in 0 until tamano) {
            for (columna in 0 until tamano) {
                val casilla = casillas[fila][columna]
                val encendida = luces[fila][columna] == 1

                casilla.text = luces[fila][columna].toString()
                casilla.setBackgroundColor(if (encendida) colorEncendida else colorApagada)
                casilla.setTextColor(if (encendida) textoEncendida else textoApagada)
            }
        }
    }
}

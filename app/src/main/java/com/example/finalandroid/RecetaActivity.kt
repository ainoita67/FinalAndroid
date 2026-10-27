package com.example.finalandroid

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecetaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idReceta = intent.extras?.getInt("idReceta") ?:0
        enableEdgeToEdge()
        setContentView(R.layout.activity_receta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val receta = MainActivity.listaRecetas.buscar(idReceta)

        val instrucciones = receta.instrucciones.joinToString(separator = "\n")


        findViewById<TextView>(R.id.textTitulo).text = receta.titulo
        findViewById<TextView>(R.id.textCategoria).text = receta.categoria
        findViewById<TextView>(R.id.textPreparacion).text = "${receta.tiempoPreparacion} m"
        findViewById<TextView>(R.id.textCoccion).text = "${receta.tiempoCoccion} m"
        findViewById<RatingBar>(R.id.ratingBar).rating = receta.valoracio
        findViewById<TextView>(R.id.textInstruccionesPrueba).text = instrucciones

    }
}

// HACER RAMAS GIT!!!!!!!
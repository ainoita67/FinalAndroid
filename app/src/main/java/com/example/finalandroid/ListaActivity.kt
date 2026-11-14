package com.example.finalandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalandroid.vista.AdaptadorLista

class ListaActivity : AppCompatActivity() {

    // Lo guardamos como propiedad para poder usarlo también en onResume
    private lateinit var adaptador: AdaptadorLista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val recycler = findViewById<RecyclerView>(R.id.lista)
        adaptador = AdaptadorLista(this)
        recycler.adapter = adaptador
        val layout = LinearLayoutManager(this)
        recycler.layoutManager = layout

        findViewById<Button>(R.id.botonNuevaReceta).setOnClickListener {
            startActivity(Intent(this, NuevaRecetaActivity::class.java))
        }
    }

    // onResume se ejecuta cada vez que la pantalla vuelve a verse,
    // por ejemplo al volver de crear una receta nueva
    override fun onResume() {
        super.onResume()
        // Avisamos al adaptador de que la lista ha cambiado para que la vuelva a pintar
        adaptador.notifyDataSetChanged()
    }
}
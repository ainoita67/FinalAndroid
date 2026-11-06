package com.example.finalandroid

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplicacionlista.datos.ListaRecetas

class MainActivity : AppCompatActivity() {

    companion object {
        val listaRecetas = ListaRecetas()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        listaRecetas.poblar()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.boton).setOnClickListener {
            dialogoElegir()
        }

        findViewById<Button>(R.id.bLista).setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }

    fun dialogoElegir(){
        val entrada = EditText(this)
        entrada.inputType = InputType.TYPE_CLASS_NUMBER
        AlertDialog.Builder(this)
            .setTitle("Elegir una receta")
            .setTitle("Introduce un número para elegir una receta")
            .setView(entrada)
            .setPositiveButton("Buscar"){ p0, p1 ->
                val num = entrada.text.toString().toInt()
//                val recetaSeleccionada = listaRecetas.buscar(num)
//                Log.d("BUSCA", recetaSeleccionada.toString())
                val intent = Intent(this, RecetaActivity::class.java)
                intent.putExtra("idReceta", num)
                startActivity(intent)
            }
            .setNeutralButton("Cancelar", null)
            .show()
    }
}
package com.example.finalandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView

class MenuJuegosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_juegos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialCardView>(R.id.cardTijeras).setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }

        findViewById<MaterialCardView>(R.id.cardDados).setOnClickListener {
            val intent = Intent(this, DadosActivity::class.java)
            startActivity(intent)
        }

        findViewById<MaterialCardView>(R.id.cardLuces).setOnClickListener {
            startActivity(Intent(this, LucesActivity::class.java))
        }
    }
}

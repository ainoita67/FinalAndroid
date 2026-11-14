package com.example.finalandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalandroid.modelo.Calculadora

class CalculadoraActivity : AppCompatActivity(), View.OnClickListener {
    val calc = Calculadora()
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultado = findViewById(R.id.resultado)

        val listaBotones = listOf<Button>(
            findViewById(R.id.bBorrar),
            findViewById(R.id.bDividir),
            findViewById(R.id.bMultiplicar),
            findViewById(R.id.bRestar),
            findViewById(R.id.bSumar),
            findViewById(R.id.b0),
            findViewById(R.id.b1),
            findViewById(R.id.b2),
            findViewById(R.id.b3),
            findViewById(R.id.b4),
            findViewById(R.id.b5),
            findViewById(R.id.b6),
            findViewById(R.id.b7),
            findViewById(R.id.b8),
            findViewById(R.id.b9),
            findViewById(R.id.bComa),
            findViewById(R.id.bIgual)
        )

        for (i in listaBotones) i.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.b0 -> calc.introducirNum('0')
            R.id.b1 -> calc.introducirNum('1')
            R.id.b2 -> calc.introducirNum('2')
            R.id.b3 -> calc.introducirNum('3')
            R.id.b4 -> calc.introducirNum('4')
            R.id.b5 -> calc.introducirNum('5')
            R.id.b6 -> calc.introducirNum('6')
            R.id.b7 -> calc.introducirNum('7')
            R.id.b8 -> calc.introducirNum('8')
            R.id.b9 -> calc.introducirNum('9')
            R.id.bComa -> calc.introducirComa()
            R.id.bSumar -> calc.operacion('+')
            R.id.bRestar -> calc.operacion('-')
            R.id.bMultiplicar -> calc.operacion('x')
            R.id.bDividir -> calc.operacion('/')
            R.id.bIgual -> calc.igual()
            R.id.bBorrar -> calc.clear()
        }
        resultado.text = calc.pantalla()
    }
}

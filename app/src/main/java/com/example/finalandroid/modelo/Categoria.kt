package com.example.finalandroid.modelo

import com.example.finalandroid.R

// imagen: icono de la categoría
// texto: nombre para mostrar en pantalla
enum class Categoria(val imagen: Int, val texto: String) {
    DESAYUNOS(R.drawable.desayuno, "Desayunos"),
    ENTRANTES(R.drawable.entrante, "Entrantes"),
    ENSALADAS(R.drawable.ensalada, "Ensaladas"),
    PRIMEROS_PLATOS(R.drawable.primer_plato, "Primeros platos"),
    SEGUNDOS_PLATOS(R.drawable.segundo_plato, "Segundos platos"),
    ACOMPANAMIENTOS(R.drawable.acompanamiento, "Acompañamientos"),
    POSTRES(R.drawable.postre, "Postres"),
    BEBIDAS(R.drawable.bebida, "Bebidas")
}

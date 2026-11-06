package com.example.aplicacionlista.modelo

import com.example.finalandroid.modelo.Categoria

data class Receta(
    val titulo: String,
    val categoria: Categoria,
    val tiempoPreparacion: Int, //minutos
    var tiempoCoccion: Int, //minutos
    var ingredientes: MutableList<String>,
    var cantidadesIngredientes: MutableList<String>,
    var instrucciones: MutableList<String>,
    var valoracio: Float, //1-5
)
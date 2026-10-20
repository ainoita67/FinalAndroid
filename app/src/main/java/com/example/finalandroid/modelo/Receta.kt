package com.example.aplicacionlista.modelo

data class Receta(
    val titulo: String,
    val categoria: String,
    val tiempoPreparacion: Int, //minutos
    var tiempoCoccion: Int, //minutos
    var ingredientes: MutableList<String>,
    var cantidadesIngredientes: MutableList<String>,
    var instrucciones: MutableList<String>
)
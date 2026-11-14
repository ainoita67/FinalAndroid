package com.example.aplicacionlista.modelo

import com.example.finalandroid.modelo.Categoria
import com.example.finalandroid.modelo.Ingrediente

data class Receta(
    val titulo: String,
    val categoria: Categoria,
    val tiempoPreparacion: Int, //minutos
    var tiempoCoccion: Int, //minutos
    var raciones: Int, //número de personas
    var ingredientes: MutableList<Ingrediente>,
    var instrucciones: MutableList<String>,
    var valoracio: Float, //1-5
) {

    // Texto para mostrar en pantalla: "1 ración" o "4 raciones"
    fun racionesTexto(): String {
        return if (raciones == 1) "1 ración" else "$raciones raciones"
    }
}

package com.example.finalandroid.modelo

// Un ingrediente de una receta: nombre, cantidad y unidad de medida juntos.
// Si cantidad es null significa "al gusto" (por ejemplo, la sal).
data class Ingrediente(
    val nombre: String,
    val cantidad: Double? = null,
    val unidad: Unidad? = null,
) {

    // Devuelve la cantidad lista para mostrar en pantalla, por ejemplo "200 g" o "3 unidades"
    fun cantidadTexto(): String {
        if (cantidad == null) return "Al gusto"

        // 200.0 -> "200"   y   0.5 -> "0.5"
        val numero = if (cantidad % 1.0 == 0.0) cantidad.toInt().toString() else cantidad.toString()

        if (unidad == null) return numero

        // "1 diente" pero "3 dientes"
        val nombreUnidad = if (cantidad <= 1.0) unidad.singular else unidad.plural
        return "$numero $nombreUnidad"
    }
}

package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.Receta
import kotlin.String

interface RepositorioRecetas {

    fun poblar() {
        nueva(
            Receta(
                "Brownie de chocolate",
                "Postre",
                25,
                45,
                mutableListOf("Chocolate", "Mantequilla", "Azúcar", "Huevos", "Harina"),
                mutableListOf("200 g", "150 g", "150 g", "3 unidades", "100 g"),
                mutableListOf(
                    "Precalentar el horno a 180 grados.",
                    "Derretir el chocolate con la mantequilla.",
                    "Batir los huevos con el azúcar.",
                    "Mezclar todos los ingredientes.",
                    "Hornear durante 45 minutos."
                )
            )
        )

        nueva(
            Receta(
                "Tortilla de patatas",
                "Plato principal",
                15,
                25,
                mutableListOf("Patatas", "Huevos", "Cebolla", "Aceite de oliva", "Sal"),
                mutableListOf("500 g", "4 unidades", "1 unidad", "50 ml", "Al gusto"),
                mutableListOf(
                    "Pelar y cortar las patatas.",
                    "Freír las patatas con la cebolla.",
                    "Batir los huevos y añadir las patatas.",
                    "Cuajar la tortilla en una sartén por ambos lados."
                )
            )
        )

        nueva(
            Receta(
                "Ensalada César",
                "Ensalada",
                15,
                0,
                mutableListOf("Lechuga", "Pollo", "Picatostes", "Queso parmesano", "Salsa César"),
                mutableListOf("200 g", "150 g", "50 g", "30 g", "Al gusto"),
                mutableListOf(
                    "Lavar y cortar la lechuga.",
                    "Cocinar el pollo y cortarlo en tiras.",
                    "Mezclar la lechuga con el pollo y los picatostes.",
                    "Añadir el queso parmesano y la salsa César."
                )
            )
        )

        nueva(
            Receta(
                "Espaguetis a la carbonara",
                "Plato principal",
                10,
                15,
                mutableListOf("Espaguetis", "Panceta", "Huevos", "Queso parmesano", "Pimienta"),
                mutableListOf("200 g", "100 g", "2 unidades", "50 g", "Al gusto"),
                mutableListOf(
                    "Cocer los espaguetis en agua con sal.",
                    "Dorar la panceta en una sartén.",
                    "Batir los huevos con el queso parmesano.",
                    "Mezclar los espaguetis con la panceta.",
                    "Añadir la mezcla de huevo y queso fuera del fuego.",
                    "Servir con pimienta al gusto."
                )
            )
        )

        nueva(
            Receta(
                "Tarta de queso",
                "Postre",
                20,
                40,
                mutableListOf("Queso crema", "Huevos", "Azúcar", "Nata", "Galletas", "Mantequilla"),
                mutableListOf("500 g", "3 unidades", "150 g", "200 ml", "150 g", "75 g"),
                mutableListOf(
                    "Triturar las galletas y mezclarlas con la mantequilla derretida.",
                    "Cubrir la base del molde con la mezcla de galletas.",
                    "Batir el queso crema con el azúcar, los huevos y la nata.",
                    "Verter la mezcla en el molde.",
                    "Hornear a 180 grados durante 40 minutos.",
                    "Dejar enfriar antes de servir."
                )
            )
        )

        nueva(
            Receta(
                "Gazpacho andaluz",
                "Entrante",
                15,
                0,
                mutableListOf("Tomates", "Pepino", "Pimiento verde", "Ajo", "Aceite de oliva", "Vinagre", "Sal"),
                mutableListOf("1 kg", "1 unidad", "1 unidad", "1 diente", "50 ml", "20 ml", "Al gusto"),
                mutableListOf(
                    "Lavar y trocear los tomates, el pepino y el pimiento.",
                    "Pelar el ajo.",
                    "Introducir todos los ingredientes en una batidora.",
                    "Añadir el aceite, el vinagre y la sal.",
                    "Triturar hasta obtener una mezcla homogénea.",
                    "Refrigerar antes de servir."
                )
            )
        )
    }

    fun nueva(r: Receta)
    fun actualizar(id: Int, r: Receta)
    fun borrar(id: Int)
    fun buscar(id: Int): Receta
    fun longitud(): Int
}
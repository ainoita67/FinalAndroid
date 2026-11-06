package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.Receta
import com.example.finalandroid.modelo.Categoria
import kotlin.String

interface RepositorioRecetas {

    fun poblar() {
        nueva(
            Receta(
                "Brownie de chocolate",
                Categoria.POSTRES,
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
                ),
                5f
            )
        )

        nueva(
            Receta(
                "Tortilla de patatas",
                Categoria.ENTRANTES,
                15,
                25,
                mutableListOf("Patatas", "Huevos", "Cebolla", "Aceite de oliva", "Sal"),
                mutableListOf("500 g", "4 unidades", "1 unidad", "50 ml", "Al gusto"),
                mutableListOf(
                    "Pelar y cortar las patatas.",
                    "Freír las patatas con la cebolla.",
                    "Batir los huevos y añadir las patatas.",
                    "Cuajar la tortilla en una sartén por ambos lados."
                ),
                4f
            )
        )

        nueva(
            Receta(
                "Ensalada César",
                Categoria.ENSALADAS,
                15,
                0,
                mutableListOf("Lechuga", "Pollo", "Picatostes", "Queso parmesano", "Salsa César"),
                mutableListOf("200 g", "150 g", "50 g", "30 g", "Al gusto"),
                mutableListOf(
                    "Lavar y cortar la lechuga.",
                    "Cocinar el pollo y cortarlo en tiras.",
                    "Mezclar la lechuga con el pollo y los picatostes.",
                    "Añadir el queso parmesano y la salsa César."
                ),
                2f
            )
        )

        nueva(
            Receta(
                "Espaguetis a la carbonara",
                Categoria.PRIMEROS_PLATOS,
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
                ),
                4f
            )
        )

        nueva(
            Receta(
                "Tarta de queso",
                Categoria.POSTRES,
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
                ),
                3f
            )
        )

        nueva(
            Receta(
                "Gazpacho andaluz",
                Categoria.ENTRANTES,
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
                ),
                5f
            )
        )

        nueva(
            Receta(
                "Tostada con tomate y aceite",
                Categoria.DESAYUNOS,
                5,
                3,
                mutableListOf("Pan", "Tomate", "Aceite de oliva", "Sal"),
                mutableListOf("2 rebanadas", "1 unidad", "20 ml", "Al gusto"),
                mutableListOf(
                    "Tostar las rebanadas de pan.",
                    "Rallar el tomate.",
                    "Untar el tomate sobre el pan.",
                    "Añadir el aceite y la sal."
                ),
                4f
            )
        )

        nueva(
            Receta(
                "Tortitas con miel",
                Categoria.DESAYUNOS,
                10,
                15,
                mutableListOf("Harina", "Leche", "Huevos", "Levadura", "Miel"),
                mutableListOf("200 g", "250 ml", "2 unidades", "1 cucharadita", "Al gusto"),
                mutableListOf(
                    "Mezclar la harina con la levadura.",
                    "Añadir la leche y los huevos y batir hasta que no haya grumos.",
                    "Cocinar cucharadas de masa en una sartén antiadherente.",
                    "Dar la vuelta cuando salgan burbujas.",
                    "Servir con miel."
                ),
                4f
            )
        )

        nueva(
            Receta(
                "Pollo asado con limón",
                Categoria.SEGUNDOS_PLATOS,
                15,
                60,
                mutableListOf("Muslos de pollo", "Limón", "Ajo", "Romero", "Aceite de oliva", "Sal"),
                mutableListOf("4 unidades", "1 unidad", "3 dientes", "Al gusto", "40 ml", "Al gusto"),
                mutableListOf(
                    "Precalentar el horno a 200 grados.",
                    "Colocar el pollo en una bandeja con el ajo y el romero.",
                    "Exprimir el limón por encima y añadir el aceite y la sal.",
                    "Hornear durante 60 minutos, dándole la vuelta a mitad de cocción."
                ),
                4f
            )
        )

        nueva(
            Receta(
                "Merluza a la plancha",
                Categoria.SEGUNDOS_PLATOS,
                10,
                10,
                mutableListOf("Merluza", "Ajo", "Perejil", "Aceite de oliva", "Sal"),
                mutableListOf("2 lomos", "2 dientes", "Al gusto", "30 ml", "Al gusto"),
                mutableListOf(
                    "Salar los lomos de merluza.",
                    "Calentar una plancha con un poco de aceite.",
                    "Cocinar el pescado unos 4 minutos por cada lado.",
                    "Aliñar con ajo picado y perejil."
                ),
                3f
            )
        )

        nueva(
            Receta(
                "Patatas panaderas",
                Categoria.ACOMPANAMIENTOS,
                15,
                45,
                mutableListOf("Patatas", "Cebolla", "Ajo", "Aceite de oliva", "Perejil", "Sal"),
                mutableListOf("600 g", "1 unidad", "2 dientes", "50 ml", "Al gusto", "Al gusto"),
                mutableListOf(
                    "Precalentar el horno a 190 grados.",
                    "Cortar las patatas y la cebolla en rodajas finas.",
                    "Colocarlas en una bandeja con el ajo, el aceite y la sal.",
                    "Hornear durante 45 minutos removiendo de vez en cuando.",
                    "Espolvorear con perejil antes de servir."
                ),
                4f
            )
        )

        nueva(
            Receta(
                "Arroz blanco",
                Categoria.ACOMPANAMIENTOS,
                5,
                18,
                mutableListOf("Arroz", "Agua", "Aceite de oliva", "Sal"),
                mutableListOf("200 g", "400 ml", "20 ml", "Al gusto"),
                mutableListOf(
                    "Rehogar el arroz con el aceite.",
                    "Añadir el agua y la sal.",
                    "Cocer a fuego medio durante 18 minutos.",
                    "Dejar reposar tapado 5 minutos."
                ),
                3f
            )
        )

        nueva(
            Receta(
                "Limonada casera",
                Categoria.BEBIDAS,
                10,
                0,
                mutableListOf("Limones", "Azúcar", "Agua", "Hielo", "Menta"),
                mutableListOf("4 unidades", "80 g", "1 l", "Al gusto", "Unas hojas"),
                mutableListOf(
                    "Exprimir los limones.",
                    "Disolver el azúcar en el zumo con un poco de agua.",
                    "Añadir el resto del agua y mezclar.",
                    "Servir con hielo y hojas de menta."
                ),
                3f
            )
        )

        nueva(
            Receta(
                "Batido de fresa",
                Categoria.BEBIDAS,
                5,
                0,
                mutableListOf("Fresas", "Leche", "Plátano", "Miel"),
                mutableListOf("200 g", "300 ml", "1 unidad", "1 cucharada"),
                mutableListOf(
                    "Lavar y quitar el rabito a las fresas.",
                    "Pelar el plátano y trocearlo.",
                    "Batir todos los ingredientes hasta obtener una textura cremosa.",
                    "Servir frío."
                ),
                4f
            )
        )

        nueva(
            Receta(
                "Ensalada de tomate y atún",
                Categoria.ENSALADAS,
                10,
                0,
                mutableListOf("Tomates", "Atún en lata", "Cebolla", "Aceitunas", "Aceite de oliva"),
                mutableListOf("3 unidades", "2 latas", "1/2 unidad", "50 g", "30 ml"),
                mutableListOf(
                    "Cortar los tomates y la cebolla.",
                    "Mezclarlos en un bol con el atún y las aceitunas.",
                    "Aliñar con aceite y sal."
                ),
                3f
            )
        )
    }

    fun nueva(r: Receta)
    fun actualizar(id: Int, r: Receta)
    fun borrar(id: Int)
    fun buscar(id: Int): Receta
    fun longitud(): Int
}
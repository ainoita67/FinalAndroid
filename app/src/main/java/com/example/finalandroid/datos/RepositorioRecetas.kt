package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.Receta
import com.example.finalandroid.modelo.Categoria
import com.example.finalandroid.modelo.Ingrediente
import com.example.finalandroid.modelo.Unidad
import kotlin.String

interface RepositorioRecetas {

    fun poblar() {
        nueva(
            Receta(
                "Brownie de chocolate",
                Categoria.POSTRES,
                25,
                45,
                8, // raciones
                mutableListOf(
                    Ingrediente("Chocolate", 200.0, Unidad.GRAMOS),
                    Ingrediente("Mantequilla", 150.0, Unidad.GRAMOS),
                    Ingrediente("Azúcar", 150.0, Unidad.GRAMOS),
                    Ingrediente("Huevos", 3.0, Unidad.UNIDADES),
                    Ingrediente("Harina", 100.0, Unidad.GRAMOS)
                ),
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
                4, // raciones
                mutableListOf(
                    Ingrediente("Patatas", 500.0, Unidad.GRAMOS),
                    Ingrediente("Huevos", 4.0, Unidad.UNIDADES),
                    Ingrediente("Cebolla", 1.0, Unidad.UNIDADES),
                    Ingrediente("Aceite de oliva", 50.0, Unidad.MILILITROS),
                    Ingrediente("Sal")
                ),
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
                2, // raciones
                mutableListOf(
                    Ingrediente("Lechuga", 200.0, Unidad.GRAMOS),
                    Ingrediente("Pollo", 150.0, Unidad.GRAMOS),
                    Ingrediente("Picatostes", 50.0, Unidad.GRAMOS),
                    Ingrediente("Queso parmesano", 30.0, Unidad.GRAMOS),
                    Ingrediente("Salsa César")
                ),
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
                2, // raciones
                mutableListOf(
                    Ingrediente("Espaguetis", 200.0, Unidad.GRAMOS),
                    Ingrediente("Panceta", 100.0, Unidad.GRAMOS),
                    Ingrediente("Huevos", 2.0, Unidad.UNIDADES),
                    Ingrediente("Queso parmesano", 50.0, Unidad.GRAMOS),
                    Ingrediente("Pimienta")
                ),
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
                8, // raciones
                mutableListOf(
                    Ingrediente("Queso crema", 500.0, Unidad.GRAMOS),
                    Ingrediente("Huevos", 3.0, Unidad.UNIDADES),
                    Ingrediente("Azúcar", 150.0, Unidad.GRAMOS),
                    Ingrediente("Nata", 200.0, Unidad.MILILITROS),
                    Ingrediente("Galletas", 150.0, Unidad.GRAMOS),
                    Ingrediente("Mantequilla", 75.0, Unidad.GRAMOS)
                ),
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
                4, // raciones
                mutableListOf(
                    Ingrediente("Tomates", 1.0, Unidad.KILOS),
                    Ingrediente("Pepino", 1.0, Unidad.UNIDADES),
                    Ingrediente("Pimiento verde", 1.0, Unidad.UNIDADES),
                    Ingrediente("Ajo", 1.0, Unidad.DIENTES),
                    Ingrediente("Aceite de oliva", 50.0, Unidad.MILILITROS),
                    Ingrediente("Vinagre", 20.0, Unidad.MILILITROS),
                    Ingrediente("Sal")
                ),
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
                1, // raciones
                mutableListOf(
                    Ingrediente("Pan", 2.0, Unidad.REBANADAS),
                    Ingrediente("Tomate", 1.0, Unidad.UNIDADES),
                    Ingrediente("Aceite de oliva", 20.0, Unidad.MILILITROS),
                    Ingrediente("Sal")
                ),
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
                4, // raciones
                mutableListOf(
                    Ingrediente("Harina", 200.0, Unidad.GRAMOS),
                    Ingrediente("Leche", 250.0, Unidad.MILILITROS),
                    Ingrediente("Huevos", 2.0, Unidad.UNIDADES),
                    Ingrediente("Levadura", 1.0, Unidad.CUCHARADITAS),
                    Ingrediente("Miel")
                ),
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
                4, // raciones
                mutableListOf(
                    Ingrediente("Muslos de pollo", 4.0, Unidad.UNIDADES),
                    Ingrediente("Limón", 1.0, Unidad.UNIDADES),
                    Ingrediente("Ajo", 3.0, Unidad.DIENTES),
                    Ingrediente("Romero"),
                    Ingrediente("Aceite de oliva", 40.0, Unidad.MILILITROS),
                    Ingrediente("Sal")
                ),
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
                2, // raciones
                mutableListOf(
                    Ingrediente("Lomos de merluza", 2.0, Unidad.UNIDADES),
                    Ingrediente("Ajo", 2.0, Unidad.DIENTES),
                    Ingrediente("Perejil"),
                    Ingrediente("Aceite de oliva", 30.0, Unidad.MILILITROS),
                    Ingrediente("Sal")
                ),
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
                4, // raciones
                mutableListOf(
                    Ingrediente("Patatas", 600.0, Unidad.GRAMOS),
                    Ingrediente("Cebolla", 1.0, Unidad.UNIDADES),
                    Ingrediente("Ajo", 2.0, Unidad.DIENTES),
                    Ingrediente("Aceite de oliva", 50.0, Unidad.MILILITROS),
                    Ingrediente("Perejil"),
                    Ingrediente("Sal")
                ),
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
                2, // raciones
                mutableListOf(
                    Ingrediente("Arroz", 200.0, Unidad.GRAMOS),
                    Ingrediente("Agua", 400.0, Unidad.MILILITROS),
                    Ingrediente("Aceite de oliva", 20.0, Unidad.MILILITROS),
                    Ingrediente("Sal")
                ),
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
                4, // raciones
                mutableListOf(
                    Ingrediente("Limones", 4.0, Unidad.UNIDADES),
                    Ingrediente("Azúcar", 80.0, Unidad.GRAMOS),
                    Ingrediente("Agua", 1.0, Unidad.LITROS),
                    Ingrediente("Hielo"),
                    Ingrediente("Menta")
                ),
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
                2, // raciones
                mutableListOf(
                    Ingrediente("Fresas", 200.0, Unidad.GRAMOS),
                    Ingrediente("Leche", 300.0, Unidad.MILILITROS),
                    Ingrediente("Plátano", 1.0, Unidad.UNIDADES),
                    Ingrediente("Miel", 1.0, Unidad.CUCHARADAS)
                ),
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
                2, // raciones
                mutableListOf(
                    Ingrediente("Tomates", 3.0, Unidad.UNIDADES),
                    Ingrediente("Atún en lata", 2.0, Unidad.LATAS),
                    Ingrediente("Cebolla", 0.5, Unidad.UNIDADES),
                    Ingrediente("Aceitunas", 50.0, Unidad.GRAMOS),
                    Ingrediente("Aceite de oliva", 30.0, Unidad.MILILITROS)
                ),
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
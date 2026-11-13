package com.example.finalandroid.modelo

// Unidades de medida que se pueden usar en los ingredientes.
// Cada una guarda cómo se escribe en singular ("1 diente") y en plural ("3 dientes").
enum class Unidad(val singular: String, val plural: String) {
    GRAMOS("g", "g"),
    KILOS("kg", "kg"),
    MILILITROS("ml", "ml"),
    LITROS("l", "l"),
    UNIDADES("unidad", "unidades"),
    DIENTES("diente", "dientes"),
    REBANADAS("rebanada", "rebanadas"),
    LATAS("lata", "latas"),
    CUCHARADAS("cucharada", "cucharadas"),
    CUCHARADITAS("cucharadita", "cucharaditas")
}

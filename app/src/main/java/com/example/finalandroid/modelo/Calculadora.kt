package com.example.finalandroid.modelo


class Calculadora {
    // num1: primer operando (el que se guarda al pulsar una operación)
    // num2: número que se está escribiendo / resultado que se muestra
    var num1: String = ""
        private set
    var num2: String = ""
        private set
    private var operacion: Char? = null

    fun introducirNum(n: Char) {
        this.num2 += n
    }

    fun introducirComa() {
        if (!this.num2.contains(".")) {
            // si no hay número todavía, empezamos con "0."
            if (this.num2.isEmpty()) this.num2 = "0"
            this.introducirNum('.')
        }
    }

    fun operacion(op: Char) {
        // si ya había una operación pendiente y un segundo número, la resolvemos primero
        if (this.operacion != null && this.num1.isNotEmpty() && this.num2.isNotEmpty()) {
            igual()
        }
        // si no se ha escrito número, no hay nada que guardar: solo cambiamos la operación
        if (this.num2.isNotEmpty()) {
            this.num1 = this.num2
            this.num2 = ""
        }
        this.operacion = op
    }

    fun clear() {
        this.num1 = ""
        this.num2 = ""
        this.operacion = null
    }

    fun igual() {
        // si falta algún número o la operación, no se puede calcular
        val n1 = this.num1.toDoubleOrNull() ?: return
        val n2 = this.num2.toDoubleOrNull() ?: return

        val res = when (this.operacion) {
            '+' -> n1 + n2
            '-' -> n1 - n2
            'x' -> n1 * n2
            '/' -> if (n2 == 0.0) Double.NaN else n1 / n2
            else -> return
        }

        this.num1 = ""
        this.operacion = null
        this.num2 = if (res.isNaN()) "" else formatear(res)
    }

    // texto a mostrar en pantalla
    fun pantalla(): String = when {
        this.num2.isNotEmpty() -> this.num2
        this.num1.isNotEmpty() -> this.num1
        else -> "0"
    }

    // quita el ".0" de los resultados enteros (5.0 -> 5)
    private fun formatear(d: Double): String =
        if (d % 1.0 == 0.0 && !d.isInfinite()) d.toLong().toString() else d.toString()
}

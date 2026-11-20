package com.example.finalandroid.modelo

enum class TipoDado(val caras: Int) {
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20),
    D100(100);

    override fun toString() = "d$caras"
}

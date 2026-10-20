package com.example.aplicacionlista.datos

import com.example.aplicacionlista.modelo.Receta

class ListaRecetas : RepositorioRecetas{
    private val lista: MutableList<Receta> = mutableListOf()
    override fun nueva(r: Receta) {
        lista.add(r)
    }

    override fun actualizar(id: Int, r: Receta) {
        lista[id] = r
    }

    override fun borrar(id: Int) {
        lista.removeAt(id)
    }

    //override fun buscar(id: Int): Personaje {
    //    return lista[id]
    //}

    override fun buscar(id: Int): Receta = lista[id]

    override fun longitud(): Int {
        return lista.size
    }
}
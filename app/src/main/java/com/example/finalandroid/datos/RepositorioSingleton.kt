package com.example.finalandroid.datos

import com.example.aplicacionlista.datos.ListaRecetas
import com.example.aplicacionlista.datos.RepositorioRecetas

class RepositorioSingleton private constructor(){

    companion object{
        val instance = RepositorioSingleton()
    }

    val listaRecetas: RepositorioRecetas = ListaRecetas();

    init {
        listaRecetas.poblar()
    }

}
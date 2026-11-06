package com.example.finalandroid.vista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.finalandroid.MainActivity
import com.example.finalandroid.R

class AdaptadorLista(val contexto: Context) : RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {

    val inflador = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorItems {
        val vista = inflador.inflate(R.layout.tarjeta_receta, parent, false)
        return CreadorItems(vista)
    }

    override fun onBindViewHolder(
        holder: CreadorItems,
        position: Int
    ) {
        val receta = MainActivity.listaRecetas.buscar(position)
        val icono = holder.itemView.findViewById<ImageView>(R.id.imgCat)
        val tpreparacion = "Tiempo de preparación: ${receta.tiempoPreparacion}"
        val tcoccion = "Tiempo de cocción: ${receta.tiempoCoccion}"


        holder.itemView.findViewById<TextView>(R.id.nombre)
            .text = receta.titulo
        val draw = AppCompatResources.getDrawable(contexto, receta.categoria.imagen)
        icono.setImageDrawable(draw)
        holder.itemView.findViewById<TextView>(R.id.preparacion)
            .text = tpreparacion
        holder.itemView.findViewById<TextView>(R.id.coccion)
            .text = tcoccion

    }

    override fun getItemCount(): Int {
        return MainActivity.listaRecetas.longitud()
    }

    class CreadorItems(itemView: View) : RecyclerView.ViewHolder(itemView)
}
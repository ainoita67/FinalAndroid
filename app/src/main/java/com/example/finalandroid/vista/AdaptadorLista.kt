package com.example.finalandroid.vista

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.example.finalandroid.MainActivity
import com.example.finalandroid.R
import com.example.finalandroid.RecetaActivity
import com.example.finalandroid.datos.RepositorioSingleton

class AdaptadorLista(val contexto: Context) : RecyclerView.Adapter<AdaptadorLista.CreadorItems>() {

    val lista = RepositorioSingleton.instance.listaRecetas

    val inflador = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CreadorItems {
        val vista = inflador.inflate(R.layout.tarjeta_receta, parent, false)
        return CreadorItems(vista, contexto)
    }

    override fun onBindViewHolder(
        holder: CreadorItems,
        position: Int
    ) {
        val receta = lista.buscar(position)
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
        holder.itemView.findViewById<TextView>(R.id.raciones)
            .text = "Raciones: ${receta.raciones}"

    }

    override fun getItemCount(): Int {
        return lista.longitud()
    }

    class CreadorItems(itemView: View, val contexto: Context) : RecyclerView.ViewHolder(itemView) {

        init {
            val layout = itemView.findViewById<LinearLayout>(R.id.base_tarjeta)
            layout.setOnClickListener {
                val position = bindingAdapterPosition
                val intent = Intent(contexto, RecetaActivity::class.java)
                intent.putExtra("idReceta", position)
                contexto.startActivity(intent)

            }
        }

    }
}
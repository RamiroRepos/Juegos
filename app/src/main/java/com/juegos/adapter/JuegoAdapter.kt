package com.juegos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.juegos.databinding.JuegoFilaBinding
import com.juegos.model.Juego


class JuegoAdapter : RecyclerView.Adapter<JuegoAdapter.JuegoViewHolder>() {

    //Una lista para almacenar la informacion de los lugares
    private var listaJuegos = emptyList<Juego>()

    inner class JuegoViewHolder(private val itemBinding: JuegoFilaBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(juego: Juego) {
            itemBinding.tvNombre.text = juego.nombre
            itemBinding.tvCalificacion.text = juego.calificacion
            itemBinding.tvCategoria.text = juego.categoria
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegoViewHolder {
        val itemBinding = JuegoFilaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JuegoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: JuegoViewHolder, position: Int) {
        val juegoActual = listaJuegos[position]
        holder.bind(juegoActual)
    }

    override fun getItemCount(): Int {
        return listaJuegos.size
    }

    fun setData(juegos: List<Juego>){
        this.listaJuegos = juegos
        notifyDataSetChanged() //Provoca que se redibuje la lista
    }
}
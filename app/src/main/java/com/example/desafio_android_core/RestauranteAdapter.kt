package com.example.desafio_android_core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapter (private val restaurantes: ArrayList<Restaurante>, val listener: OnClickRestauranteListener): RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>() {

    interface OnClickRestauranteListener {

        fun onClickRestaurante(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurante, parent, false)
        return RestauranteViewHolder(itemView)
    }

    override fun getItemCount(): Int = restaurantes.size

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {

        var restaurante : Restaurante = restaurantes.get(position)
        holder.tvNomeRestaurante.text = restaurante.nome
        holder.tvImagemRestaurante.setImageResource(restaurante.foto)
        holder.tvEnderecoRestaurante.text = restaurante.endereco
        holder.tvDadosRestaurante.text = restaurante.dadosAdicionais
    }

    inner class RestauranteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var tvNomeRestaurante: TextView = itemView.findViewById(R.id.tvNomeRestaurante)
        var tvImagemRestaurante: ImageView = itemView.findViewById(R.id.tvImagemRestaurante)
        var tvEnderecoRestaurante: TextView = itemView.findViewById(R.id.tvEnderecoRestaurante)
        var tvDadosRestaurante: TextView = itemView.findViewById(R.id.tvDadosRestaurante)

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClickRestaurante(position)
            }
        }
    }
}
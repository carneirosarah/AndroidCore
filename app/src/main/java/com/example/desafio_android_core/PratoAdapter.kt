package com.example.desafio_android_core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PratoAdapter(private val pratos: ArrayList<Prato>, val listener: OnClickPratoListener): RecyclerView.Adapter<PratoAdapter.PratoViewHolder>() {

    interface OnClickPratoListener {

        fun onClickPrato(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratoAdapter.PratoViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_prato, parent, false)
        return PratoViewHolder(itemView)
    }

    override fun getItemCount(): Int = pratos.size

    override fun onBindViewHolder(holder: PratoAdapter.PratoViewHolder, position: Int) {

        var prato: Prato = pratos.get(position)
        holder.tvNomePrato.text = prato.nome
        holder.imagemRestaurante.setImageResource(prato.foto)
    }

    inner class PratoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var tvNomePrato: TextView = itemView.findViewById(R.id.tvNomePrato)
        var imagemRestaurante: ImageView = itemView.findViewById(R.id.tvImagemPrato)

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onClickPrato(position)
            }
        }

    }
}
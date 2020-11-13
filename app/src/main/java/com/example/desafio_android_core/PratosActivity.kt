package com.example.desafio_android_core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pratos.*

class PratosActivity : AppCompatActivity(), PratoAdapter.OnClickPratoListener {

    var pratos = getPratosList()
    val adapter = PratoAdapter(pratos, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pratos)

        val extras = intent.extras

        if(extras?.get("restaurante") != null) {

            val restaurante : Restaurante = extras?.get("restaurante") as Restaurante
            tv_restaurante_nome.text = restaurante.nome
            iv_restaurante_foto.setImageResource(restaurante.foto)
        }

        button_back.setOnClickListener {
            finish()
        }

        rvPrato1.adapter = adapter
        rvPrato2.adapter = adapter
        rvPrato1.layoutManager = LinearLayoutManager(this)
        rvPrato2.layoutManager = LinearLayoutManager(this)
        rvPrato1.setHasFixedSize(true)
        rvPrato2.setHasFixedSize(true)
        rvPrato1.setNestedScrollingEnabled(false)
        rvPrato2.setNestedScrollingEnabled(false)

    }

    fun getPratosList() = arrayListOf<Prato>(
            Prato(1,"Salada com molho Gengibre", "abcd", R.mipmap.image3_foreground),
            Prato(2,"Salada com molho Gengibre", "abcd", R.mipmap.image3_foreground),
            Prato(3,"Salada com molho Gengibre", "abcd", R.mipmap.image3_foreground),
            Prato(4,"Salada com molho Gengibre", "abcd", R.mipmap.image3_foreground),
            Prato(5,"Salada com molho Gengibre", "abcd", R.mipmap.image3_foreground)
    )

    override fun onClickPrato(position: Int) {
        var prato = pratos.get(position)
        val intent = Intent(this, DetalhesActivity::class.java)
        intent.putExtra("prato", prato)
        startActivity(intent)
    }
}
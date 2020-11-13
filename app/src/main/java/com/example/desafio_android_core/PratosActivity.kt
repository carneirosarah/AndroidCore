package com.example.desafio_android_core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pratos.*

class PratosActivity : AppCompatActivity(), PratoAdapter.OnClickPratoListener {

    var pratos = arrayListOf<Prato>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pratos)

        val extras = intent.extras

        val restaurante : Restaurante = extras?.get("restaurante") as Restaurante
        tv_restaurante_nome.text = restaurante.nome
        iv_restaurante_foto.setImageResource(restaurante.foto)

        this.pratos = restaurante.pratos
        val adapter = PratoAdapter(pratos, this)

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

    override fun onClickPrato(position: Int) {
        var prato = pratos.get(position)
        val intent = Intent(this, DetalhesActivity::class.java)
        intent.putExtra("prato", prato)
        startActivity(intent)
    }
}
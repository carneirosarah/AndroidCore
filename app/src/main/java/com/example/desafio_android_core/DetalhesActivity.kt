package com.example.desafio_android_core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detalhes.*

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val extras = intent.extras
        val prato : Prato = extras?.get("prato") as Prato

        tv_prato_nome.text = prato.nome
        iv_prato_foto.setImageResource(prato.foto)
        tv_pratos_desc.text = prato.descricao

        button_back.setOnClickListener{
            finish()
        }
    }
}
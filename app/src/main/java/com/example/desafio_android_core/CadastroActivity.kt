package com.example.desafio_android_core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        topAppBar.setNavigationOnClickListener {
            finish()
        }

        registerButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
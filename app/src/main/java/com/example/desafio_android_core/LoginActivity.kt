package com.example.desafio_android_core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


        loginRegisterButton.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }
}
package com.example.desafio_android_core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RestauranteAdapter.OnClickRestauranteListener {

    var restaurantes = getAllRestaurantes()
    val adapter = RestauranteAdapter(restaurantes, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvRestaurante.adapter = adapter
        rvRestaurante.layoutManager = LinearLayoutManager(this)
        rvRestaurante.setHasFixedSize(true)
    }

    fun getAllRestaurantes() = arrayListOf<Restaurante>(
            Restaurante(1, "Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", R.mipmap.image1_novo_foreground),
            Restaurante(2, "Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", R.mipmap.image3_foreground),
            Restaurante(3, "Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", R.mipmap.image5_foreground),
            Restaurante(4, "Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", R.mipmap.image2_foreground)
    )

    override fun onClickRestaurante(position: Int) {
        var restaurante = restaurantes.get(position)
        Toast.makeText(this, restaurante.nome, Toast.LENGTH_SHORT).show()
    }
}
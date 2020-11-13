package com.example.desafio_android_core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    fun getAllRestaurantes() : ArrayList<Restaurante> {
        val pratos = arrayListOf<Prato>(
                Prato(1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.mipmap.image3_foreground),
                Prato(2, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.mipmap.image3_foreground),
                Prato(3, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.mipmap.image3_foreground)
        )
         return arrayListOf<Restaurante>(
                Restaurante(1, "Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", R.mipmap.image1_novo_foreground, pratos),
                Restaurante(2, "Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", R.mipmap.image3_foreground, pratos),
                Restaurante(3, "Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", R.mipmap.image5_foreground, pratos),
                Restaurante(4, "Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", R.mipmap.image2_foreground, pratos)
         )
    }

    override fun onClickRestaurante(position: Int) {
        var restaurante = restaurantes.get(position)
        val intent = Intent(this, PratosActivity::class.java)
        intent.putExtra("restaurante", restaurante)
        startActivity(intent)
    }
}
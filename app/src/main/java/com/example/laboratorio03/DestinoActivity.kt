package com.example.laboratorio03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_destino.*

class DestinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destino)

        var lvacunas : MutableList<String> = mutableListOf()
        val bundleRecepcion = intent.extras


        bundleRecepcion?.let{

            val nmascota = it.getString("key_mascotaname","") ?: ""
            val emascota = it.getString("key_mascotaage", "") ?: ""
            val tmascota = it.getString("key_mascotatype", "") ?: ""
            val lvacunas = it.getString("key_vacunas","") ?: ""
            val imagenmascota = imgMascota


            tvNamemascota.text="El nombre de la mascota es $nmascota "
            tvAgemascota.text="La edad de la mascota es $emascota años"
            tvTypemascota.text="La mascota es un $tmascota"

            if (tmascota=="Perro") {
                val imagenelegida=R.drawable.perro
                imagenmascota.setImageResource(imagenelegida)
             } else if (tmascota=="Gato") {
                val imagenelegida=R.drawable.gato
                imagenmascota.setImageResource(imagenelegida)
            } else if (tmascota=="Conejo") {
                val imagenelegida=R.drawable.conejo
                imagenmascota.setImageResource(imagenelegida)
            }

            if (lvacunas == "[]"){
                tvLista.text = "Ninguna"
            }else {
                val final = lvacunas.length-1
                val vaclimpia: String = lvacunas.substring(1, final)
                //tvLista.text = lvacunas
                tvLista.text = vaclimpia
            }

            rbRetornar.setOnClickListener{
                finish()
            }
        }

    }
}



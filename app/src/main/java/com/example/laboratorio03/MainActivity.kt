package com.example.laboratorio03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEnviar.setOnClickListener {

            var tipomascota=""
            val nombremascota=edtNombremascota.text.toString()
            val edadmascota=edtEdadmascota.text.toString()

            // validaciones

            if (nombremascota.isEmpty()){
                Toast.makeText(this,"Debe ingresar el nombre de la mascota", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (edadmascota.isEmpty()){
                Toast.makeText(this,"Deb ingresar la edad de la mascota", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (rdbPerro.isChecked) {
                tipomascota="Perro"
            } else if (rdbGato.isChecked) {
                tipomascota = "Gato"
            } else if (rdbConejo.isChecked) {
                tipomascota = "Conejo"
            }

            var listavacunas : MutableList<String> = mutableListOf()

            if (chkAde.isChecked){
                listavacunas.add("Adenovirus")
            }
            if (chkDis.isChecked){
                listavacunas.add("Distemper")
            }
            if (chkLep.isChecked){
                listavacunas.add("Leptospirosis")
            }
            if (chkPar.isChecked){
                listavacunas.add("Parvovirosis")
            }
            if (chkRab.isChecked){
                listavacunas.add("Rabia")
            }

            val enviados=Bundle()
            enviados.putString("key_mascotaname",nombremascota)
            enviados.putString("key_mascotaage",edadmascota)
            enviados.putString("key_mascotatype",tipomascota)
            enviados.putString("key_vacunas", listavacunas.toString())

            val intent=Intent(this,DestinoActivity::class.java)
            intent.putExtras(enviados)
            startActivity(intent)



        }
    }
}
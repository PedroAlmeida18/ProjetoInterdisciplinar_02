package com.example.calculadorao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var expressao: TextView
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        expressao = findViewById(R.id.expressao)
        resultado = findViewById(R.id.resultado)

        findViewById<TextView>(R.id.numero_zero).setOnClickListener { acrescentarExpress("0", true) }
        findViewById<TextView>(R.id.numero_one).setOnClickListener { acrescentarExpress("1", true) }
        findViewById<TextView>(R.id.numero_two).setOnClickListener { acrescentarExpress("2", true) }
        findViewById<TextView>(R.id.numero_thrree).setOnClickListener { acrescentarExpress("3", true) }
        findViewById<TextView>(R.id.numero_four).setOnClickListener { acrescentarExpress("4", true) }
        findViewById<TextView>(R.id.numero_five).setOnClickListener { acrescentarExpress("5", true) }
        findViewById<TextView>(R.id.numero_six).setOnClickListener { acrescentarExpress("6", true) }
        findViewById<TextView>(R.id.numero_seven).setOnClickListener { acrescentarExpress("7", true) }
        findViewById<TextView>(R.id.numero_oito).setOnClickListener { acrescentarExpress("8", true) }
        findViewById<TextView>(R.id.numero_nove).setOnClickListener { acrescentarExpress("9", true) }
    }

    private fun acrescentarExpress(string: String, limpar_dados: Boolean) {
        if (resultado.text.isNotEmpty()) {
            expressao.text = ""
        }
        if (limpar_dados) {
            resultado.text = ""
            expressao.append(string)
        } else {
            expressao.append(resultado.text)
            expressao.append(string)
            resultado.text = " "
        }
    }
}

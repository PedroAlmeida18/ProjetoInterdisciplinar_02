package com.example.calculadorao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

import kotlin.Exception

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
        findViewById<TextView>(R.id.ponto).setOnClickListener { acrescentarExpress(",", true) }
        // Operadores
        findViewById<TextView>(R.id.multilica).setOnClickListener { acrescentarExpress("x", false) }
        findViewById<TextView>(R.id.soma).setOnClickListener { acrescentarExpress("+", false) }
        findViewById<TextView>(R.id.subtraçao).setOnClickListener { acrescentarExpress("-", false) }
        findViewById<TextView>(R.id.divisor).setOnClickListener { acrescentarExpress("/", false) }

       // Ação de Limpar
        findViewById<TextView>(R.id.limpar).setOnClickListener {
            expressao.text =""
            resultado.text=""

        }
         findViewById<TextView>(R.id.back_space).setOnClickListener{
            val string = expressao.text.toString()

            if(string.isNotBlank()){
                expressao.text= string.substring(0,string.length-1)
            }
            resultado.text=" "
        }
        /*findViewById<TextView>(R.id.igual).setOnClickListener{
            try {
                val expression = ExpressionBuilder(expressao.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    resultado.text = longResult.toString()
                } else {
                    resultado.text = result.toString()
                }
            } catch (e: Exception) {
                // Lida com exceções, se necessário
            }
        } */




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
            resultado.text = "  "
        }
    }
}

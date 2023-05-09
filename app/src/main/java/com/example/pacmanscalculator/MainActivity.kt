package com.example.pacmanscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils.formatNumber
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //0->nada; 1->suma; 2->resta; 3->mult; 4->div
    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIgual: Button = findViewById(R.id.buttonigual)
        val btnDel: Button = findViewById(R.id.buttonDel)
        val btnClear: Button = findViewById(R.id.buttonC)
        val btnCambioSigno: Button = findViewById(R.id.buttoncambio)
        tv_num1 = findViewById(R.id.historial)
        tv_num2 = findViewById(R.id.editText)

        btnIgual.setOnClickListener{
            var num2 = tv_num2.text.toString().toDouble()
            var res = 0.0
            when(oper){
                1-> res = numero1 + num2
                2-> res = numero1- num2
                3-> res = numero1 * num2
                4-> res = numero1 / num2
                5-> res = Math.pow(numero1, num2)
            }
            tv_num2.setText(res.toString())
            tv_num1.setText("")
        }


        btnDel.setOnClickListener{
            var num2 = tv_num2.text.toString()
            if (num2.isNotEmpty()) {
                tv_num2.text = num2.substring(0, num2.length - 1)
            }
        }

        btnClear.setOnClickListener {
            // Lógica para reiniciar la calculadora
            tv_num1.text = ""
            tv_num2.text = ""
            oper = 0
        }
        btnCambioSigno.setOnClickListener{
            var num2 = tv_num2.text.toString().toDouble()
            num2 = num2 * -1
            tv_num2.setText(num2.toString())
        }


    }

    fun clicNumero(view: View){
        var num2 = tv_num2.text.toString()

        when(view.id){
            R.id.button0 -> tv_num2.setText(num2+"0")
            R.id.button1 -> tv_num2.setText(num2+"1")
            R.id.button2 -> tv_num2.setText(num2+"2")
            R.id.button3 -> tv_num2.setText(num2+"3")
            R.id.button4 -> tv_num2.setText(num2+"4")
            R.id.button5 -> tv_num2.setText(num2+"5")
            R.id.button6 -> tv_num2.setText(num2+"6")
            R.id.button7 -> tv_num2.setText(num2+"7")
            R.id.button8 -> tv_num2.setText(num2+"8")
            R.id.button9 -> tv_num2.setText(num2+"9")
            R.id.buttondot -> tv_num2.setText(num2+".")
        }
    }

    fun clicOperacion(view: View){
        var num2 = tv_num2.text.toString()
        numero1 = num2.toString().toDouble()
        tv_num2.setText("")
        when(view.id){
            R.id.buttonmas -> {
                tv_num1.setText(num2+"+")
                oper = 1
            }
            R.id.buttonmenos ->{
                tv_num1.setText(num2+"-")
                oper = 2
            }
            R.id.buttonmult ->{
                tv_num1.setText(num2+"*")
                oper = 3
            }
            R.id.buttondiv -> {
                tv_num1.setText(num2+"/")
                oper = 4
            }
            R.id.buttonpotencia -> {
                tv_num1.setText(num2+"^")
                oper = 5
            }
        }
    }
}
package com.marlena.cubos_kotlin01

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.linear_main.*

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_main)

        initListener()
    }

    fun initListener() {
        calculateBTN?.setOnClickListener {
            getValue()
        }

        cleanBTN.setOnClickListener {
            startClean()
        }
    }

    fun getValue() { //colocar altura, peso aqui

        var weight = 0f
        var height = 0f

        when {
            weightEDT?.text?.toString().isNullOrBlank() ->
                Toast.makeText(this, "Algo errado, O peso está em branco!", Toast.LENGTH_LONG).show()
            heightEDT?.text?.toString().isNullOrBlank() ->
                Toast.makeText(this, "Algo errado, A altura está em branco!", Toast.LENGTH_LONG).show()
            else -> {
                weight = weightEDT.text.toString().toFloat()
                height = heightEDT.text.toString().toFloat()
                Toast.makeText(this, "Dados: $weight e $height!", Toast.LENGTH_LONG).show()
            }
        }

        val title = when (startCalculate(weight, height)) {
            in 0f..16f -> "Algo errado, valores incorretos!"
            in 16f..19f -> "Abaixo do Peso"
            in 19f..25f -> "Peso Ideal"
            in 25f..50f -> "Sobrepeso"
            else -> {
                startClean()
                "Valores Incorretos! Digite valores novamente!"
            }
        }
        Toast.makeText(this, title, Toast.LENGTH_LONG).show()
    }

    private fun startCalculate(weight: Float, height: Float): Float {
        return weight / (height * height)
    }
    //    fun goCalculate() =  Toast.makeText(this, "${weightEDT.text.toString().toFloat()/(heightEDT.text.toString().toFloat()*heightEDT.text.toString().toFloat())}", Toast.LENGTH_LONG).show()

    private fun startClean() {
        weightEDT.setText("")
        heightEDT.setText("")
    }
}
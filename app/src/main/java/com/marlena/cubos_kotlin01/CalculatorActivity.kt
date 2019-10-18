package com.marlena.cubos_kotlin01

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    fun getValue() {

        var weight = 0f
        var height = 0f

        when {
            weightEDT?.text?.toString().isNullOrBlank() ->
                Toast.makeText(
                    this,
                    "Algo errado, O peso está em branco!",
                    Toast.LENGTH_LONG
                ).show()
            heightEDT?.text?.toString().isNullOrBlank() ->
                Toast.makeText(
                    this,
                    "Algo errado, A altura está em branco!",
                    Toast.LENGTH_LONG
                ).show()
            else -> {
                weight = weightEDT.text.toString().toFloat()
                height = heightEDT.text.toString().toFloat()
                val message = "Dados:$weight kg e $height m"
                informationsTXT.setText(message)
                Toast.makeText(this, "Dados: $weight e $height!", Toast.LENGTH_LONG).show()
            }
        }
        val alertCod: Float = startCalculate(weight, height)
        callAlert(alertCod)
    }

    private fun startCalculate(weight: Float, height: Float): Float {
        return weight / (height * height)
    }

    private fun startClean() {
        weightEDT.setText("")
        heightEDT.setText("")
        informationsTXT.setText(getString(R.string.informations))
    }

    private fun callAlert(alertCod: Float) {

        val alertDialog = AlertDialog.Builder(this)

        when (alertCod) {
            in 0f..16f -> {
                alertDialog.setTitle("Erro.")
                alertDialog.setMessage("Algo errado, valores incorretos!")
            }
            in 16f..19f -> {
                alertDialog.setTitle("Atenção!")
                alertDialog.setMessage("Você está abaixo do seu Peso Ideal")
            }
            in 19f..25f -> {
                alertDialog.setTitle("Parabéns!")
                alertDialog.setMessage("Você está no seu Peso Ideal")
            }
            in 25f..50f -> {
                alertDialog.setTitle("Atenção!")
                alertDialog.setMessage("Você está acima do seu Peso Ideal")
            }
            else -> {
                startClean()
                alertDialog.setTitle("Erro.Valores Incorretos!")
                alertDialog.setMessage("Digite valores novamente!")
            }
        }
        alertDialog.show()
    }
}
package com.marlena.cubos_kotlin01.calculator

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class CalculatorPresenter(private val view: Calculator.View): AppCompatActivity(), Calculator.Presenter {

    override fun callAlert(alertCod: Float) {

        val alertDialog = AlertDialog.Builder(view.getViewContext())

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
                view.startClean()
                alertDialog.setTitle("Erro.Valores Incorretos!")
                alertDialog.setMessage("Digite valores novamente!")
            }
        }
        alertDialog.show()
    }

    override fun requestMessage(message: String) {
        view.showMessage(message)
    }

}
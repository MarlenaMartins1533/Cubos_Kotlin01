package com.marlena.cubos_kotlin01.calculator

import androidx.appcompat.app.AppCompatActivity

class CalculatorPresenter(private val view: Calculator.View): AppCompatActivity(), Calculator.Presenter {

    override fun requestMessage(message: String) {
        view.showMessage(message)
    }

}
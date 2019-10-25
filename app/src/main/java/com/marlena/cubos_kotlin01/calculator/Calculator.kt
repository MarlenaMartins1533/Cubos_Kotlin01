package com.marlena.cubos_kotlin01.calculator

import com.marlena.cubos_kotlin01.Scene

interface Calculator {

    interface View: Scene.View{
        fun showMessage(message: String)
        fun getValue()
        fun startCalculate(weight: Float, height: Float): Float
        fun callAlert(alertCod: Float)
        fun startClean()
    }
    interface Presenter: Scene.Presenter{
        fun requestMessage(message: String)
    }
}
package com.marlena.cubos_kotlin01.calculator

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.marlena.cubos_kotlin01.R
import kotlinx.android.synthetic.main.linear_main.*

class CalculatorActivity: AppCompatActivity(), Calculator.View {

    private lateinit var presenter: Calculator.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_main)

        presenter = CalculatorPresenter(this)

        initListener()
    }

    override fun initListener() {
        calculateBTN?.setOnClickListener {
            getValue()
        }

        cleanBTN.setOnClickListener {
            startClean()
        }
    }

    override fun getValue() {

        var weight = 0f
        var height = 0f

        when {
            weightEDT?.text?.toString().isNullOrEmpty() ->
                presenter.requestMessage("Algo errado, O peso está em branco!")

            heightEDT?.text?.toString().isNullOrEmpty() ->
                presenter.requestMessage("Algo errado, A altura está em branco!")

            else -> {
                weight = weightEDT.text.toString().toFloat()
                height = heightEDT.text.toString().toFloat()
                val message = "Dados: $weight kg e $height m"
                informationsTXT.setText(message)
                presenter.requestMessage("Dados: $weight e $height!")
            }
        }
        val alertCod: Float = startCalculate(weight, height)
        presenter.callAlert(alertCod)
    }

    override fun startCalculate(weight: Float, height: Float): Float {
        return weight / (height * height)
    }

    override fun startClean() {
        weightEDT.setText("")
        heightEDT.setText("")
        informationsTXT.setText(getString(R.string.informations))
    }

    override fun showMessage(message: String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    override fun getViewContext(): Context {
        return this
    }
}
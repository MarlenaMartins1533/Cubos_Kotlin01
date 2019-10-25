package com.marlena.cubos_kotlin01.calculator

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.marlena.cubos_kotlin01.R
import kotlinx.android.synthetic.main.linear_main.*

class CalculatorActivity : AppCompatActivity(), Calculator.View {

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
                informationsTXT.text = message
                presenter.requestMessage("Dados: $weight e $height!")
            }
        }
        val alertCod: Float = startCalculate(weight, height)
        callAlert(alertCod)
    }

    override fun startCalculate(weight: Float, height: Float): Float = weight / (height * height)

    //colocar arquivo de string, chamar como resource
    override fun callAlert(alertCod: Float) =
        when (alertCod) {
            in 0f..16f ->
                setupAlertDialog("Erro.", "Algo errado, valores incorretos!")
            in 16f..19f ->
                setupAlertDialog("Atenção!", "Você está abaixo do seu Peso Ideal")
            in 19f..25f ->
                setupAlertDialog("Parabéns!", "Você está no seu Peso Ideal")
            in 25f..50f ->
                setupAlertDialog("Atenção!", "Você está acima do seu Peso Ideal")
            else -> {
                startClean()
                setupAlertDialog("Erro.Valores Incorretos!", "Digite novamente!")
            }
        }

    private fun setupAlertDialog(title: String, message: String) {
        AlertDialog.Builder(this).apply {
            setTitle(title)
            setMessage(message)
            show()
        }
    }

    override fun startClean() {
        weightEDT.setText("")
        heightEDT.setText("")
        informationsTXT.text = getString(R.string.informations)
    }

    override fun showMessage(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    override fun getViewContext():Context = this
}
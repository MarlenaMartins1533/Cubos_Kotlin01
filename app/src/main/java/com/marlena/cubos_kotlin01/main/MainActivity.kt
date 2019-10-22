package com.marlena.cubos_kotlin01.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marlena.cubos_kotlin01.R
import com.marlena.cubos_kotlin01.calculator.CalculatorActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),Main.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    override fun initListener() {

        imcBTN.setOnClickListener {
            goToCalculatorActivity()
        }
    }

    private fun goToCalculatorActivity() {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }
    override fun getViewContext(): Context {
        return this
    }
}
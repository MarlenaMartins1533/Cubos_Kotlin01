package com.marlena.cubos_kotlin01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.linear_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    fun initListener() {

        imcBTN.setOnClickListener {
            goToCalculatorActivity()
        }
    }

    private fun goToCalculatorActivity() {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        tosttest("VOLTEI GALERA,onStart")
    }

    private fun tosttest(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        tosttest("VOLTEI GALERA, OnResume")
    }

    override fun onPause() {
        super.onPause()
        tosttest("VOLTEI GALERA, OnPause")
    }

    override fun onStop() {
        super.onStop()
        tosttest("VOLTEI GALERA, OnStop")
    }
}
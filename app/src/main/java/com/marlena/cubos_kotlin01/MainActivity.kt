package com.marlena.cubos_kotlin01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso
            .get()
            .load("https://amopets.com.br/wp-content/uploads/2018/06/gatos-felizes.gif")
            .into(imageView)

    }

    override fun onStart() {
        super.onStart()
        tosttest("VOLTEI GALERA,onStart")
    }

    private fun tosttest(text:String){
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
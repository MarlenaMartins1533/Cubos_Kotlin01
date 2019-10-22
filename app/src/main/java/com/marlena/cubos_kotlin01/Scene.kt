package com.marlena.cubos_kotlin01

import android.content.Context

interface Scene {
    interface View{
        fun initListener()
        fun getViewContext(): Context
    }
    interface Presenter{}
}
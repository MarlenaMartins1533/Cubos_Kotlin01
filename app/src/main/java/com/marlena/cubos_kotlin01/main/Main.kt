package com.marlena.cubos_kotlin01.main

import com.marlena.cubos_kotlin01.Scene

interface Main {

    interface View: Scene.View {}
    interface Presenter: Scene.Presenter {}
}
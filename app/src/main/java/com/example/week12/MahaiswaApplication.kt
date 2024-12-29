package com.example.week12

import android.app.Application
import com.example.week12.dependensiinjection.AppContainer
import com.example.week12.dependensiinjection.MahasiswaContainer

class MahaiswaApplication: Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}
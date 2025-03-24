package com.example.projeto


import android.app.Application
import com.example.projeto.data.AppContainer
import com.example.projeto.data.AppDataContainer

class CadastroApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
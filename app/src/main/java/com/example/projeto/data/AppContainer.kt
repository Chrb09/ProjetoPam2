package com.example.projeto.data

import android.content.Context

interface AppContainer {
    val clienteRepository: ClienteRepository
}


class AppDataContainer(private val context: Context) : AppContainer {

    override val clienteRepository: ClienteRepository by lazy {
        OfflineClienteRepository(ClienteDatabase.getDatabase(context).clienteDao())
    }
}
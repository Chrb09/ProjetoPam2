package com.example.projeto.data

import kotlinx.coroutines.flow.Flow

interface ClienteRepository {

    suspend fun insert(cliente: Cliente)

    suspend fun update(cliente: Cliente)

    suspend fun delete(cliente: Cliente)

    fun listar(): Flow<List<Cliente>>

}

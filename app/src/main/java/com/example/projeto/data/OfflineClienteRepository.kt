package com.example.projeto.data

import kotlinx.coroutines.flow.Flow

class OfflineClienteRepository(private val clienteDao: ClienteDAO) : ClienteRepository {
    override fun listar(): Flow<List<Cliente>> = clienteDao.listar()

    override suspend fun insert(cliente: Cliente) = clienteDao.insert(cliente)

    override suspend fun delete(cliente: Cliente) = clienteDao.delete(cliente)

    override suspend fun update(cliente: Cliente) = clienteDao.update(cliente)
}

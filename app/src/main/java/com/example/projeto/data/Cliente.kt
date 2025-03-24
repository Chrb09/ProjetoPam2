package com.example.projeto.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cliente")
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val endereco: String,
    val bairro: String,
    val cep: String,
    val cidade: String,
    val estado: String,
)

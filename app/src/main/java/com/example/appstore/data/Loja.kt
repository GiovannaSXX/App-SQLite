package com.example.appstore.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loja")
data class Loja(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val marca: String,
    val tamanho: String,
    val cor: String,
    val material: String,
    val tipo: String
)

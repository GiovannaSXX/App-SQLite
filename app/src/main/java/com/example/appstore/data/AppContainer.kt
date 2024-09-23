package com.example.appstore.data

import android.content.Context
import androidx.room.Room

class AppContainer(context: Context) {
    private val database: LojaDatabase by lazy {
        Room.databaseBuilder(context, LojaDatabase::class.java, "db_loja").build()
    }

    val lojaRepository: LojaRepository by lazy {
        LojaRepository(database.lojaDao())
    }
}
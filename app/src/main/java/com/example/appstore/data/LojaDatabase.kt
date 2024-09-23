package com.example.appstore.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Loja::class], version = 1, exportSchema = false)
abstract class LojaDatabase : RoomDatabase() {
    abstract fun lojaDao(): LojaDao
}

package com.example.projeto.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Cliente::class], version = 1, exportSchema = false
)
abstract class ClienteDatabase: RoomDatabase() {
    abstract  fun clienteDao(): ClienteDAO
    companion object{
        @Volatile
        private var instance: ClienteDatabase? = null

        fun getDatabase(context: Context): ClienteDatabase{
            return instance?: synchronized(this){
                Room.databaseBuilder(context, ClienteDatabase::class.java, "item_database")
                    .build()
                    .also { instance = it }
            }
        }
    }
}
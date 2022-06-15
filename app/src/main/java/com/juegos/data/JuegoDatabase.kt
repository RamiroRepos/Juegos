package com.juegos.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.juegos.model.Juego

@Database(entities=[Juego::class],version=-1,exportSchema = false)
abstract class JuegoDatabase: RoomDatabase() {
    abstract fun juegoDao() : JuegoDao

    companion object{
        @Volatile
        private var INSTANCE: JuegoDatabase? = null

        fun getDatabase(context: android.content.Context) : JuegoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, JuegoDatabase::class.java, "juego_database").build()
                INSTANCE = instance
                return instance
            }

        }
    }
}

package com.juegos.repository

import androidx.lifecycle.LiveData
import com.juegos.data.JuegoDao
import com.juegos.model.Juego

class JuegoRepository(private val juegoDao: JuegoDao) {

    val getAllData: LiveData<List<Juego>> = juegoDao.getAllData()

    suspend fun addJuego(juego: Juego){
        juegoDao.addJuego(juego)
    }

    suspend fun updateJuego(juego: Juego){
        juegoDao.updateJuego(juego)
    }

    suspend fun deleteJuego(juego: Juego){
        juegoDao.deleteJuego(juego)
    }
}
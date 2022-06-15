package com.juegos.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.juegos.model.Juego

@Dao
interface JuegoDao {

    @Query ( "SELECT * FROM JUEGO")
    fun getAllData() : LiveData<List<Juego>>

    @Insert( onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJuego(juego: Juego)

    @Update( onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateJuego(juego: Juego)

    @Delete
    suspend fun deleteJuego(juego: Juego)
}
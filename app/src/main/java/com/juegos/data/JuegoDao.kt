package com.juegos.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.juegos.model.Juego

@Dao
interface JuegoDao {

    @Insert( onConflict = OnConflictStrategy.IGNORE)
    fun addJuego(Juego: Juego)

    @Update( onConflict = OnConflictStrategy.IGNORE)
    fun updateJuego(Juego: Juego)

    @Delete
    fun deleteJuego(Juego: Juego)

    @Query ( "SELECT * FROM JUEGO")
    fun getAllData() : LiveData<List<Juego>>
}
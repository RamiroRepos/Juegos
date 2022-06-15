package com.juegos.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.juegos.data.JuegoDatabase
import com.juegos.model.Juego
import com.juegos.repository.JuegoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JuegoViewModel(application: Application) : AndroidViewModel(application) {
    val getAllDate: LiveData<List<Juego>>

    private val repository: JuegoRepository

    init {
        val juegoDao = JuegoDatabase.getDatabase(application).juegoDao()
        repository = JuegoRepository(juegoDao)
        getAllDate = repository.getAllData
    }

    fun addJuego (juego: Juego){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addJuego(juego)}
    }

    fun updateJuego (juego: Juego){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateJuego(juego)}
    }

    fun deteleJuego (juego: Juego){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delteJuego(juego)}
    }


}
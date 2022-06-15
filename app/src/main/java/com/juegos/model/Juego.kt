package com.juegos.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "juego")
data class Juego(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "categoria")
    val categoria: String?,
    @ColumnInfo(name = "calificacion")
    val calificacion: String?,
    @ColumnInfo(name = "tamaño")
    val tamaño: String?,
    @ColumnInfo(name = "plataforma")
    val plataforma: String?,
    @ColumnInfo(name = "multiplayer")
    val multiplayer: String?,
    @ColumnInfo(name = "rutaAudio")
    val rutaAudio: String?,
    @ColumnInfo(name = "rutaImagen")
    val rutaImagen: String?,) : Parcelable


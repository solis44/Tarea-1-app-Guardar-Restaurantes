package com.restaurante.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName="Restaurante")
data class Restaurante (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="Nombre")
    val Nombre: String?,
    @ColumnInfo(name="Ubicacion")
    val Ubicacion: String?,
    @ColumnInfo(name="Telefono")
    val Telefono: String?,
    @ColumnInfo(name="Platillos")
    val Platillos: String?

    ): Parcelable
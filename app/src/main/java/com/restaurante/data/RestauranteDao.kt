package com.restaurante.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.restaurante.model.Restaurante

@Dao
interface RestauranteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRestaurante(Restaurante : Restaurante)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateRestaurante(Restaurante : Restaurante)

    @Delete
    suspend fun deleteRestaurante(Restaurante : Restaurante)

    @Query("SELECT *  FROM Restaurante")
    fun getRestaurante() : LiveData<List<Restaurante>>
}
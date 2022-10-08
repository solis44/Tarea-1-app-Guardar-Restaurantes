package com.restaurante.repository

import androidx.lifecycle.LiveData
import com.restaurante.data.RestauranteDao
import com.restaurante.model.Restaurante

class RestauranteRepository(private val RestauranteDao: RestauranteDao) {

    suspend fun saveRestaurante(Restaurante : Restaurante){
        if(Restaurante.id==0){
            RestauranteDao.addRestaurante(Restaurante)
        }else {
            RestauranteDao.addRestaurante(Restaurante)
        }
    }

    suspend fun deleteRestaurante(Restaurante : Restaurante){
        if(Restaurante.id==0){
            RestauranteDao.deleteRestaurante(Restaurante)
        }
    }

    val getRestaurante : LiveData<List<Restaurante>> = RestauranteDao.getRestaurante()
}
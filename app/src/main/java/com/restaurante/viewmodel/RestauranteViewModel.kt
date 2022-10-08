package com.restaurante.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.restaurante.data.RestauranteDataBase
import com.restaurante.model.Restaurante
import com.restaurante.repository.RestauranteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class   RestauranteViewModel(application: Application) : AndroidViewModel(application)  {

    private val RestauranteRepository: RestauranteRepository
    val getRestaurante: LiveData<List<Restaurante>>

    init {
        val lugarDao = RestauranteDataBase.getDatabase(application).RestauranteDao()
        RestauranteRepository = RestauranteRepository(lugarDao)
        getRestaurante = RestauranteRepository.getRestaurante
    }

    fun saveRestaurante(Restaurante: Restaurante){
        viewModelScope.launch(Dispatchers.IO) {
            RestauranteRepository.saveRestaurante(Restaurante) }
    }

    fun deleteRestaurante(Restaurante: Restaurante){
        viewModelScope.launch(Dispatchers.IO) {
            RestauranteRepository.deleteRestaurante(Restaurante) }
    }

}
package com.restaurante.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.restaurante.model.Restaurante

@Database(entities = [Restaurante::class], version = 1, exportSchema = false)
abstract  class RestauranteDataBase: RoomDatabase() {

    abstract fun RestauranteDao() : RestauranteDao

    companion object {
        @Volatile
        private var INSTANCE: RestauranteDataBase? = null
        fun getDatabase(context: Context) : RestauranteDataBase  {
            val local = INSTANCE
            if(local != null) {
                return local
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RestauranteDataBase::class.java,
                    "Restaurante_Database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
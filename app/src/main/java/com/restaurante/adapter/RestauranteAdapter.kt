package com.restaurante.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.restaurante.databinding.RestauranteFilaBinding
import com.restaurante.model.Restaurante

class RestauranteAdapter : RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>()
{

    inner class RestauranteViewHolder(private val itemBinding: RestauranteFilaBinding):
        RecyclerView.ViewHolder(itemBinding.root){

        fun bind(restaurante: Restaurante)
        {
            itemBinding.tvNombre.text = restaurante.Nombre
            itemBinding.tvTelefono.text = restaurante.Telefono
            itemBinding.tvUbicacion.text = restaurante.Ubicacion
            itemBinding.tvPlatillos.text = restaurante.Platillos

        }
    }

    //La lista donde estan los objetos Lugar a dibujarse
    private var listaRestaurante = emptyList<Restaurante>()



    //Esta funcion crea cajitas para cada lugar en memoria
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RestauranteViewHolder {

        val itemBinding = RestauranteFilaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return RestauranteViewHolder(itemBinding)
    }

    //Esta funcion toma un lugar y lo envia a dibujar
    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {

        val Restaurante = listaRestaurante[position]
        holder.bind(Restaurante)
    }

    // Esta funcion devuelve la cantidad de cajitas a dibujar
    override fun getItemCount(): Int {
        return listaRestaurante.size
    }

    fun setlistaRestaurante(Restaurante: List<Restaurante>)
    {
        this.listaRestaurante = Restaurante
        notifyDataSetChanged()
    }

}
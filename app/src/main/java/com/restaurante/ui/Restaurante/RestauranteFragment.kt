package com.restaurante.ui.Restaurante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.restaurante.R
import com.restaurante.adapter.RestauranteAdapter
import com.restaurante.databinding.FragmentRestauranteBinding
import com.restaurante.viewmodel.RestauranteViewModel

class RestauranteFragment : Fragment() {

    private var _binding: FragmentRestauranteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val restauranteViewModel =
            ViewModelProvider(this)[RestauranteViewModel::class.java]
        _binding = FragmentRestauranteBinding.inflate(inflater, container, false)


        binding.btFltAddRestaurante.setOnClickListener{
            findNavController().navigate(R.id.action_nav_restaurante_to_addRestauranteFragment)
        }

        val restauranteAdapter = RestauranteAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = restauranteAdapter
        reciclador.layoutManager= LinearLayoutManager(requireContext())

        restauranteViewModel.getRestaurante.observe(viewLifecycleOwner)
        {
                restaurante -> restauranteAdapter.setlistaRestaurante(restaurante)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
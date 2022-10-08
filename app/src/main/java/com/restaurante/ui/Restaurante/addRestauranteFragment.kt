package com.restaurante.ui.Restaurante

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.restaurante.R
import com.restaurante.databinding.FragmentAddRestauranteBinding
import com.restaurante.model.Restaurante
import com.restaurante.viewmodel.RestauranteViewModel

class addRestauranteFragment : Fragment() {

    private lateinit var restauranteViewModel : RestauranteViewModel
    private var _binding: FragmentAddRestauranteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        restauranteViewModel =
            ViewModelProvider(this).get(RestauranteViewModel::class.java)


        _binding = FragmentAddRestauranteBinding.inflate(inflater, container, false)

        binding.btAddRestaurante.setOnClickListener {
            addRestaurante()
        }

        return binding.root
    }

    private fun addRestaurante() {
        val nombre=binding.txtNombre.text.toString() // Obtiene el texto de lo que el usuario escribio
        if (nombre.isNotEmpty())
        {
            val telefono = binding.txtTelefono.text.toString()
            val ubicacion = binding.txtUbicacion.text.toString()
            val platillos = binding.txtPlatillos.text.toString()
            val restaurante = Restaurante(0,nombre,telefono,ubicacion,platillos)
            //Se procede a registrar el nuevo lugar
            restauranteViewModel.saveRestaurante(restaurante)
            Toast.makeText(requireContext(),getString(R.string.msg_add_Restaurante),Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_nav_restaurante_to_addRestauranteFragment)

        } else
        {// No se puede registar el lugar porque falta informacion
            Toast.makeText(requireContext(),getString(R.string.msg_falta_datos),Toast.LENGTH_SHORT).show()

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
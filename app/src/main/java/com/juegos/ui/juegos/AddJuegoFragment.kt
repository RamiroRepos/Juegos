package com.juegos.ui.juegos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.juegos.R
import com.juegos.databinding.FragmentAddJuegoBinding
import com.juegos.model.Juego
import com.juegos.viewmodel.JuegoViewModel

class AddJuegoFragment : Fragment() {

    private lateinit var juegoViewModel: JuegoViewModel

    private var _binding: FragmentAddJuegoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        juegoViewModel = ViewModelProvider(this)[JuegoViewModel::class.java]
        _binding = FragmentAddJuegoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Se agrega la funcion para agregar un lugar
        binding.btAgregar.setOnClickListener{ addLugar() }

        return binding.root
    }

    private fun addLugar() {
        val nombre = binding.etNombre.text.toString()
        if(nombre.isNotEmpty()){
            val categoria = binding.etCategoria.text.toString()
            val calificacion = binding.etCalificacion.text.toString()
            val tamaño = binding.etTamaO.text.toString()
            val juego = Juego(0, nombre, categoria, calificacion, tamaño,"","","","")
            juegoViewModel.addJuego(juego)
            Toast.makeText(requireContext(), "Lugar Agregado", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addJuegoFragment_to_nav_juego)
        }else{
            Toast.makeText(requireContext(), "Faltan Datos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
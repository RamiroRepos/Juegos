package com.juegos.ui.juego

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
        _binding = FragmentAddJuegoBinding.inflate(inflater, container, false)

        juegoViewModel = ViewModelProvider(this)[JuegoViewModel::class.java]
        //val root: View = binding.root

        //Se agrega la funcion para agregar un lugar
        binding.btAgregar.setOnClickListener{ addJuego() }

        return binding.root
    }

    private fun addJuego() {
        val nombre = binding.etNombre.text.toString()
        if(nombre.isNotEmpty()){
            val categoria = binding.etCategoria.text.toString()
            val calificacion = binding.etCalificacion.text.toString()
            val tamaño = binding.etTamaO.text.toString()
            val juego = Juego(0, nombre, categoria, calificacion, tamaño,"","","","")
            juegoViewModel.addJuego(juego)
            Toast.makeText(requireContext(), getString(R.string.msg_juego_agregado), Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addJuegoFragment_to_nav_juego)
        }else{
            Toast.makeText(requireContext(), getString(R.string.msg_faltan_datos), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
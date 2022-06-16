package com.juegos.ui.juego

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.juegos.R
import com.juegos.databinding.FragmentJuegoBinding
import com.juegos.viewmodel.JuegoViewModel

class JuegoFragment : Fragment() {

    private lateinit var juegoViewModel: JuegoViewModel
    private var _binding: FragmentJuegoBinding? = null
    private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
      juegoViewModel = ViewModelProvider(this)[JuegoViewModel::class.java]
      _binding = FragmentJuegoBinding.inflate(inflater, container, false)

      binding.fbAgregar.setOnClickListener{
          findNavController().navigate(R.id.action_nav_juego_to_addJuegoFragment)
      }
/*
      Activar el RecyclerView
      val juegoAdapter=JuegoAdapter()
      val reciclador = binding.reciclador

      reciclador.adapter = juegoAdapter
      reciclador.layoutManager= LinearLayoutManager(requireContext())

      juegoViewModel = ViewModelProvider(this)[JuegoViewModel::class.java]

      juegoViewModel.getAllDate.observe(viewLifecycleOwner){
              juegos -> juegoAdapter.setData(juegos)
      }
*/
    return binding.root
  }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
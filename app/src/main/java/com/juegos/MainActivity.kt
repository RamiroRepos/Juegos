package com.juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.juegos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Variable para acceder a la autenticacion
    private lateinit var auth: FirebaseAuth

    //Variable para acceder a los elementos de la pantalla
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Se establece el enlace con la vista xml mediante el objeto binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Se inicializa Firebase y se asigna el objeto para autenticación
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btRegistro.setOnClickListener { haceRegistro() }
        binding.btLogin.setOnClickListener { haceLogin() }
    }

        private fun haceRegistro() {

        val email = binding.etCorreo.text.toString()
        val clave = binding.etClave.text.toString()

        if (email != ""  && clave != ""){
            //Se hace el registro
            auth.createUserWithEmailAndPassword(email,clave).addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    Log.d("Creando usuario", "Registrado")
                    val user = auth.currentUser
                    actualiza(user)
                }else{
                    Log.d("Creando usuario", "Fallo")
                    Toast.makeText(baseContext,"Fallo",Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
        }
    }

    private fun actualiza(user: FirebaseUser?) {
        if (user != null){
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }

    //Esto hara que una vez autenticado.... no pida mas a menos que cierre la sesion
    public override fun onStart(){
        super.onStart()
        val usuario = auth.currentUser
        actualiza(usuario)
    }

    private fun haceLogin() {

        val email = binding.etCorreo.text.toString()
        val clave = binding.etClave.text.toString()

        if (email != ""  && clave != ""){
            //Se hace el login
            auth.signInWithEmailAndPassword(email,clave).addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    Log.d("Autenticando", "Autenticado")
                    val user = auth.currentUser
                    actualiza(user)
                }else{
                    Log.d("Autenticando", "Fallo")
                    Toast.makeText(baseContext,"Fallo",Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
        }
    }
}
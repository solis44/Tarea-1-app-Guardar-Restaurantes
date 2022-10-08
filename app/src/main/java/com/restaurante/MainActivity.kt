package com.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.restaurante.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    //    Definicion del objeto para hacer la autenticacion
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        // Crear metodo de login

        binding.btLogin.setOnClickListener {
            haceLogin();
        }

        binding.btRegister.setOnClickListener {
            haceRegister();
        }
    }

    private fun haceRegister() {
        val email = binding.etCorreo.text.trim().toString()
        val clave = binding.etClave.text.trim().toString()

        auth.createUserWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this) { task ->
                var user: FirebaseUser? = null
                if (task.isSuccessful) {
                    Log.d("Creando usuario", "Registrado")
                    user = auth.currentUser
                    actuliza(user)
                } else {
                    Log.d("Creando usuario", "Fallo")
                    Toast.makeText(baseContext, "Fallo", Toast.LENGTH_SHORT).show()
                    actuliza(null)
                }
            }

    }

    private fun actuliza(user :FirebaseUser?) {
        if(user != null){
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }

    //    Esto hara que una vez autenticado no nos vuelva a pedir las credenciales
//    a menos que se haya cerrado la sesion
    public override fun onStart(){
        super.onStart()
        val usuario = auth.currentUser
        actuliza(usuario)
    }

    private fun haceLogin() {
        val email = binding.etCorreo.text.toString()
        val clave = binding.etClave.text.toString()

        auth.signInWithEmailAndPassword(email, clave)
            .addOnCompleteListener(this) { task ->
                var user: FirebaseUser? = null
                if (task.isSuccessful) {
                    Log.d("Autenticando", "Auntenticado")
                    user = auth.currentUser
                    actuliza(user)
                } else {
                    Log.d("Autenticando", "Fallo")
                    Toast.makeText(baseContext, "Fallo", Toast.LENGTH_SHORT).show()

                    actuliza(null)
                }
            }
    }
}




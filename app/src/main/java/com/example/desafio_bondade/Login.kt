package com.example.desafio_bondade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.desafio_bondade.databinding.ActivityLoginBinding
import com.example.desafio_bondade.databinding.ActivityRegistrarBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater )
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textRegistrar.setOnClickListener{
            val intent = Intent(this, Registrar::class.java)
            startActivity(intent)
       }

        binding.buttonLogin.setOnClickListener(){
            val email = binding.editEmail1.text.toString()
            val senha = binding.editSenha1.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener{

                    if (it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)

                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Preencha todos os campos!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }


/*    override fun onStart(){
        super.onStart()

        if(firebaseAuth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }*/
}
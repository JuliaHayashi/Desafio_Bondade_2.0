package com.example.desafio_bondade

import Configuracoes
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.desafio_bondade.databinding.ActivityMainBinding
import com.example.desafio_bondade.databinding.ActivityRegistrarBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater )
        setContentView(binding.root)
        replaceFragment(Desafios())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.desafio -> replaceFragment(Desafios())
                R.id.diario -> replaceFragment(Diario())
                R.id.preferencias -> replaceFragment(Preferencias())
                R.id.configuracoes -> replaceFragment(Configuracoes())

                else ->{}
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}

package com.example.desafio_bondade

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafio_bondade.databinding.FragmentConfiguracoesBinding
import com.google.firebase.auth.FirebaseAuth

class Configuracoes : Fragment() {

    private lateinit var binding: FragmentConfiguracoesBinding
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        usuario = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfiguracoesBinding.inflate(inflater, container, false)

        binding.btnLogout.setOnClickListener {
            usuario.signOut()
            val intent = Intent(activity, Login::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return binding.root
    }
}

package com.example.desafio_bondade

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class Desafios : Fragment() {

    private val desafios = listOf(
        "Desafio 1: Planeje um encontro romântico ao pôr do sol.",
        "Desafio 2: Escolha um local com uma vista panorâmica e leve um lanche para desfrutarem enquanto observam o pôr do sol juntos.",
        "Desafio 3: Faça uma sessão de fotos juntos.",
        "Desafio 5: Visite um mercado de agricultores juntos.",
        "Desafio 6: Faça um passeio de barco, canoa ou caiaque.",
        "Desafio 7: Planeje um jantar temático baseado em um país que vocês gostariam de visitar juntos."
    )

    private lateinit var textDesafios: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desafios, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textDesafios = view.findViewById(R.id.textDesafios)

        // Get the task for today
        val task = getTodayTask()
        textDesafios.text = task
    }

    private fun getTodayTask(): String {
        val date = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())
        val taskIndex = date.toInt() % desafios.size
        return desafios[taskIndex]
    }
}

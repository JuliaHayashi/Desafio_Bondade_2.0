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
        "Escreva uma carta de amor para o seu parceiro(a).\n\n" +
                "Ideia: Escreva sobre os momentos especiais que passaram juntos e o quanto ele(a) significa para você.",

        "Escreva uma carta de amor para o seu parceiro(a).\n\n" +
                "Ideia: Escreva sobre os momentos especiais que passaram juntos e o quanto ele(a) significa para você.",

        "Faça uma atividade ao ar livre juntos.\n\n" +
                "Ideia: Visite um parque, vá dar um passeio de bicicleta ou faça um piquenique.",

        "Faça uma lista de reprodução de músicas favoritas para o seu parceiro(a).\n\n" +
                "Ideia: Inclua músicas que tenham significado para vocês ou que você saiba que ele(a) gosta.",

        "Assista a um filme juntos.\n\n" +
                "Ideia: Escolha um filme que ambos queiram ver e prepare pipoca para acompanhar.",

        "Faça uma surpresa simples, como deixar um bilhete de amor em um lugar inesperado.\n\n" +
                "Ideia: Escreva um bilhete e coloque-o no bolso da jaqueta dele(a) ou na bolsa dela.",

        "Escreva uma lista de reprodução de músicas para dançarem juntos em casa.\n\n" +
                "Ideia: Inclua músicas animadas e românticas que os façam se sentir conectados um ao outro enquanto dançam.",

        "Planeje um jantar temático baseado em um país que vocês gostariam de visitar juntos.\n\n" +
                "Ideia: Escolham um país e preparem pratos típicos desse lugar, criando uma atmosfera que os faça sentir como se estivessem lá.",

        "Escreva uma lista de coisas que você aprecia no seu parceiro(a) e compartilhe com ele(a).\n\n" +
                "Ideia: Seja específico(a) e inclua pequenos detalhes que fazem você se apaixonar por ele(a) todos os dias."
    )

    private lateinit var textDesafios: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_desafios, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textDesafios = view.findViewById(R.id.textDesafios)

        val task = getDesafio()
        textDesafios.text = task
    }

    private fun getDesafio(): String {
        val date = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date())
        val taskIndex = date.toInt() % desafios.size
        return desafios[taskIndex]
    }
}

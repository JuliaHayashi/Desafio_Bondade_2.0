import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import com.example.desafio_bondade.Login
import com.example.desafio_bondade.R
import com.example.desafio_bondade.databinding.FragmentConfiguracoesBinding
import com.google.firebase.auth.FirebaseAuth

class Configuracoes : Fragment() {

    private lateinit var binding: FragmentConfiguracoesBinding
    private lateinit var usuario: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        usuario = FirebaseAuth.getInstance()
        sharedPreferences = requireActivity().getSharedPreferences("notifications", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfiguracoesBinding.inflate(inflater, container, false)

        // Verifica o estado atual do switch e configura o listener para alterações
        binding.notificationSwitch.isChecked = isNotificationEnabled()
        binding.notificationSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            // Se o switch for ligado, ativa as notificações diárias
            if (isChecked) {
                enableNotifications()
            } else {
                // Se o switch for desligado, desativa as notificações diárias
                disableNotifications()
            }
        }

        binding.btnLogout.setOnClickListener {
            usuario.signOut()
            val intent = Intent(activity, Login::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return binding.root
    }

    // Método para verificar se as notificações estão habilitadas
    private fun isNotificationEnabled(): Boolean {
        return sharedPreferences.getBoolean("notifications_enabled", false)
    }

    // Método para ativar as notificações diárias
    private fun enableNotifications() {
        // Implemente a lógica para ativar as notificações diárias aqui
        // Por exemplo, você pode usar AlarmManager e PendingIntent para configurar as notificações
        // Lembre-se de atualizar o SharedPreferences para indicar que as notificações estão ativadas

        // Aqui está o código para exibir a notificação
        val notificationManager = requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "DesafioBondadeChannel"
        val channelName = "Desafio Bondade Channel"
        val notificationId = 1 // ID único para a notificação
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        val notificationBuilder = NotificationCompat.Builder(requireActivity(), channelId)
            .setSmallIcon(R.drawable.baseline_local_fire_department_24) // ic_notification é o nome do seu ícone de notificação
            .setContentTitle("Desafio Bondade")
            .setContentText("Um desafio acaba de sair do forno!!!")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        notificationManager.notify(notificationId, notificationBuilder.build())

        with(sharedPreferences.edit()) {
            putBoolean("notifications_enabled", true)
            apply()
        }
    }

    // Método para desativar as notificações diárias
    private fun disableNotifications() {
        // Implemente a lógica para desativar as notificações diárias aqui
        // Lembre-se de atualizar o SharedPreferences para indicar que as notificações estão desativadas
        with(sharedPreferences.edit()) {
            putBoolean("notifications_enabled", false)
            apply()
        }
    }
}

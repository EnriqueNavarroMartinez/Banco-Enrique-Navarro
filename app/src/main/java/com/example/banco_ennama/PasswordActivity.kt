package com.example.banco_ennama

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.banco_ennama.databinding.ActivityMainBinding
import com.example.banco_ennama.databinding.ActivityPasswordBinding

class PasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasswordBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var entradaValida = true

        binding.btAceptar.setOnClickListener {
            var entradaValida = true

            val password1 = binding.tietCambiocpntrasena1.text.toString()
            val password2 = binding.tietCambiocpntrasena2.text.toString()

            val passwordRegex = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#\$%^&+=!_-]).{8,}$")

            if (password1.length >= 8 && password1.matches(passwordRegex)) {
                binding.tietCambiocpntrasena1.error = null
            } else {
                binding.tietCambiocpntrasena1.error =
                    "La contraseña debe tener al menos 8 caracteres, con 1 minúscula, 1 mayúscula, 1 número y 1 símbolo"
                entradaValida = false
            }

            if (password2.length >= 8 && password2.matches(passwordRegex)) {
                binding.tietCambiocpntrasena2.error = null
            } else {
                binding.tietCambiocpntrasena2.error =
                    "La contraseña debe tener al menos 8 caracteres, con 1 minúscula, 1 mayúscula, 1 número y 1 símbolo"
                entradaValida = false
            }

            if (entradaValida && password1 != password2) {
                binding.tietCambiocpntrasena2.error = "Las contraseñas no coinciden"
                entradaValida = false
            }

            // Si todas las validaciones pasan, mostrar mensaje
            if (entradaValida) {
                binding.mensaje.text = "Contraseña cambiada correctamente"
            }
        }




        binding.btSalir.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
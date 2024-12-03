package com.example.banco_ennama.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_ennama.databinding.ActivityLoginBinding
import com.example.bancoapiprofe.bd.MiBancoOperacional
import com.example.bancoapiprofe.pojo.Cliente

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar el binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el botón "Entrar"
        binding.btEntrar.setOnClickListener {
            val dni = binding.tietDni.text.toString().trim()
            val password = binding.tietPassw.text.toString().trim()

            binding.tvErrorDni.visibility = View.GONE
            binding.tvErrorPassw.visibility = View.GONE

            var hasError = false

            // Validar el campo DNI
            if (dni.isEmpty()) {
                binding.tvErrorDni.text = "El campo DNI es obligatorio."
                binding.tvErrorDni.visibility = View.VISIBLE
                hasError = true
            }

            if (password.isEmpty()) {
                binding.tvErrorPassw.text = "El campo Contraseña es obligatorio."
                binding.tvErrorPassw.visibility = View.VISIBLE
                hasError = true
            }

            if (hasError) return@setOnClickListener

            // Operaciones del banco
            val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(this)

            // Crear el objeto cliente
            val cliente = Cliente().apply {
                setNif(dni)
                setClaveSeguridad(password)
            }

            val clienteLogeado = mbo?.login(cliente) ?: -1
            if (clienteLogeado == -1) {
                // Mostrar error si el cliente no existe
                binding.tvErrorDni.text = "El cliente no existe en la base de datos."
                binding.tvErrorDni.visibility = View.VISIBLE
            } else {
                // Navegar a la actividad principal
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Cliente", clienteLogeado)
                startActivity(intent)
            }
        }

        // Configurar el botón "Salir"
        binding.btSalir.setOnClickListener {
            finish() // Finalizar la actividad actual
        }
    }
}

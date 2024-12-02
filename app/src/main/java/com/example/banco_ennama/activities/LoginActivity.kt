package com.example.banco_ennama.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.banco_ennama.R
import com.example.banco_ennama.databinding.ActivityLoginBinding
import com.example.bancoapiprofe.bd.MiBancoOperacional
import com.example.bancoapiprofe.pojo.Cliente
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        //inicializar el binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var entradaValida = true

        binding.btEntrar.setOnClickListener {

            val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(this)

            // Introducimos los datos como si fuera la pantalla inicial
            var cliente = Cliente()
            cliente.setNif(binding.tietDni.text.toString())
            cliente.setClaveSeguridad(binding.tietPassw.text.toString())

            // Logueamos al cliente
            val clienteLogeado = mbo?.login(cliente) ?: -1
            if(clienteLogeado == -1) {
                Toast.makeText(this, "El cliente no existe en la base de datos", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Cliente", clienteLogeado)
                startActivity(intent)
            }

        }

        binding.btSalir.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
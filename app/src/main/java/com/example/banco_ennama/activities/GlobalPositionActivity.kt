package com.example.banco_ennama.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_ennama.R
import com.example.banco_ennama.adapters.CuentasListener
import com.example.banco_ennama.fragments.AccountMovementsFragment
import com.example.banco_ennama.fragments.AccountsFragment
import com.example.bancoapiprofe.pojo.Cliente
import com.example.bancoapiprofe.pojo.Cuenta

class GlobalPositionActivity : AppCompatActivity(), CuentasListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_position)

        // Recuperar el cliente de los argumentos pasados desde la actividad anterior
        val cliente = intent.getSerializableExtra("Cliente") as? Cliente

        val accountsFragment = AccountsFragment().apply {
            arguments = Bundle().apply {
                putSerializable("Cliente", cliente)
            }
        }

        // Reemplazar el fragmento en el contenedor correspondiente
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, accountsFragment)
            .commit()
    }

    // Implementación del método de la interfaz
    override fun onCuentaSeleccionada(cuenta: Cuenta) {
        val accountMovementsFragment = AccountMovementsFragment().apply {
            arguments = Bundle().apply {
                putSerializable("Cuenta", cuenta)
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, accountMovementsFragment)
            .addToBackStack(null) // Para poder regresar al fragmento anterior
            .commit()
    }

}

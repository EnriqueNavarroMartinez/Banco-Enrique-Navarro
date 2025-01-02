package com.example.banco_ennama.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.banco_ennama.R
import com.example.banco_ennama.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del Toolbar
        setSupportActionBar(binding.appbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.bank_24) // Ícono de hamburguesa o cualquier ícono que quieras usar

        // Configuración del NavigationView
        binding.navigationView?.setNavigationItemSelectedListener(this)

        // Configuración del DrawerLayout
        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.appbar,
            R.string.open_nav, R.string.close_nav
        )
        binding.drawerLayout?.addDrawerListener(toggle)
        toggle.syncState() // Sincroniza el estado del Drawer con el botón del Toolbar
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Si se presiona el ícono de hamburguesa, abrir el Drawer
                binding.drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_global_position -> {
                // Lógica para manejar el ítem "Posición Global"
                val intent = Intent(this, GlobalPositionActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_movements -> {
                // Lógica para manejar el ítem "Movimientos"
                val intent = Intent(this, MovementsActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_transfers -> {
                // Lógica para manejar el ítem "Transferencias"
                val intent = Intent(this, TransferActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_change_password -> {
                // Lógica para manejar el ítem "Cambiar Contraseña"
                val intent = Intent(this, PasswordActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_promotions -> {
                // Lógica para manejar el ítem "Promociones"
            }
            R.id.nav_atms -> {
                // Lógica para manejar el ítem "Cajeros"
            }
            R.id.nav_exit -> {
                // Lógica para manejar el ítem "Salir"
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            }
        }
        // Cerrar el Drawer después de seleccionar una opción
        binding.drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }
}

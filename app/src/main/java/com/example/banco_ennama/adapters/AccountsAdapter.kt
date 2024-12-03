package com.example.banco_ennama.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_ennama.R
import com.example.banco_ennama.databinding.ItemCuentaBinding
import com.example.banco_ennama.fragments.AccountsFragment
import com.example.bancoapiprofe.pojo.Cuenta

class AccountsAdapter(private val cuentas: List<Cuenta>, private val listener: OnClickListener) : RecyclerView.Adapter<AccountsAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCuentaBinding.bind(view)

        init {
            view.setOnClickListener {
                val cuenta = cuentas[adapterPosition]
                listener.onClick(cuenta)
            }
        }
    }

    interface OnClickListener {
        fun onClick(cuenta: Cuenta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cuenta, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = cuentas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cuenta = cuentas[position]
        with(holder) {
            val nombre = "${cuenta.getBanco()}-${cuenta.getSucursal()}-${cuenta.getDc()}-${cuenta.getNumeroCuenta()}"
            binding.nombre.text = nombre
            binding.cantidad.text = cuenta.getSaldoActual().toString()
        }
    }
}

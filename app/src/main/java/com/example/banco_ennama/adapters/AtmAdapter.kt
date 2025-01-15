package com.example.banco_ennama.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_ennama.R
import com.example.banco_ennama.databinding.ItemAtmBinding
import com.example.banco_ennama.databinding.ItemMovimientoBinding
import com.example.banco_ennama.entities.CajeroEntity
import com.example.bancoapiprofe.pojo.Movimiento

class AtmAdapter(
    private var atms: List<CajeroEntity>, // Lista de cajeros
    private val listener: AtmListener // Interfaz para manejar los clics
) : RecyclerView.Adapter<AtmAdapter.ViewHolder>() {

    // ViewHolder para el RecyclerView
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemAtmBinding.bind(view)

        init {
            // Configuramos el listener para cada item
            itemView.setOnClickListener {
                val atm = atms[adapterPosition]
                listener.onAtmSeleccionado(atm) // Cuando se selecciona un cajero
            }
        }
    }

    // Inflamos el layout para cada item y lo pasamos al ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_atm, parent, false)
        return ViewHolder(view)
    }

    // Retorna la cantidad de cajeros en la lista
    override fun getItemCount(): Int = atms.size

    // Vincula los datos del cajero al layout
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val atm = atms[position] // Obtenemos el cajero en la posición actual
        with(holder) {
            // Asignamos los datos a los TextViews
            binding.nombre.text = atm.id.toString() // Ejemplo: ID del cajero
            binding.cantidad.text = atm.direccion + atm.latitud + atm.longitud


        }
    }

    // Método para actualizar los datos del adaptador (útil si los datos cambian)
    fun updateData(newAtms: List<CajeroEntity>) {
        atms = newAtms
        notifyDataSetChanged() // Notifica al RecyclerView que los datos han cambiado
    }
}
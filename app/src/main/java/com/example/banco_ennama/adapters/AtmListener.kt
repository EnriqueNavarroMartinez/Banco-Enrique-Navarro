package com.example.banco_ennama.adapters

import com.example.banco_ennama.entities.CajeroEntity
import com.example.bancoapiprofe.pojo.Cuenta

interface AtmListener {
    fun onAtmSeleccionado(cajeroEntity: CajeroEntity)
}

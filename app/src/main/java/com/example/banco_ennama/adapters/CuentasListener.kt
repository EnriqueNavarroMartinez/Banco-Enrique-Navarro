package com.example.banco_ennama.adapters

import com.example.bancoapiprofe.pojo.Cuenta

interface CuentasListener {
    fun onCuentaSeleccionada(cuenta: Cuenta)
}

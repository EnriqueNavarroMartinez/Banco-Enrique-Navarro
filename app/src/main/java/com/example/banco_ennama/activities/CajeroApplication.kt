package com.example.banco_ennama.activities

import android.app.Application
import androidx.room.Room
import com.example.banco_ennama.database.CajeroDatabase

class CajeroApplication : Application() {

    companion object {
        lateinit var database: CajeroDatabase
    }

    override fun onCreate() {
        super.onCreate()

        // Inicializar la base de datos
        database = Room.databaseBuilder(this,
            CajeroDatabase::class.java,
            "CajeroDatabase"
        ).build()
    }
}

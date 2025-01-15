package com.example.banco_ennama.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.banco_ennama.dao.CajeroDAO
import com.example.banco_ennama.entities.CajeroEntity

@Database(entities = [CajeroEntity::class], version =1)
    abstract class CajeroDatabase : RoomDatabase() {
        abstract fun cajeroDAO(): CajeroDAO

}
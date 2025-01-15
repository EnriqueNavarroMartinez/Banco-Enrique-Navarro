package com.example.banco_ennama.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.banco_ennama.entities.CajeroEntity

@Dao
interface CajeroDAO {

    @Query("SELECT * FROM cajeros")
    fun getAllCajeros() : MutableList<CajeroEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(CajeroEntityList : List<CajeroEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCajero(cajeroEntity: CajeroEntity)

    @Update
    fun updateCajero(cajeroEntity: CajeroEntity)

    @Delete
    fun deleteCajero(cajeroEntity: CajeroEntity)

}
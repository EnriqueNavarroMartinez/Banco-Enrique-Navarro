package com.example.banco_ennama.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity (tableName = "cajeros")
data class CajeroEntity (
    @PrimaryKey(true) val id : Int = 0,
    @ColumnInfo(name = "direccion" ) var direccion : String?,
    @ColumnInfo(name = "latitud" ) var latitud : Double?,
    @ColumnInfo(name = "longitud" ) var longitud : Double?,
    @ColumnInfo(name = "zoom" ) val zoom : String?,
) : Serializable
package dev.cardoso.roomexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.cardoso.roomexample.data.dao.PasesalidaDao
import dev.cardoso.roomexample.data.entities.PasesalidaEntityData

@Database(entities = arrayOf(PasesalidaEntityData::class), version = 1)
abstract class VehiculoDatabase : RoomDatabase() {
    abstract fun getPasesalidaDao(): PasesalidaDao
}
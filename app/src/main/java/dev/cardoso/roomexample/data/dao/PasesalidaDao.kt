package dev.cardoso.roomexample.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.cardoso.roomexample.data.entities.PasesalidaEntityData
import dev.cardoso.roomexample.domain.entities.PasesalidaEntity
import io.reactivex.Flowable


@Dao
interface PasesalidaDao {
    @Query("SELECT * from pasesalida")
    fun getAllPaseSalida(): Flowable<List<PasesalidaEntityData>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllPaseSalida(pasesalida: List<PasesalidaEntityData>)

}


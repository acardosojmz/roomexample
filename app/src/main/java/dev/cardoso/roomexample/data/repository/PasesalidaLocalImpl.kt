package dev.cardoso.roomexample.data.repository

import dev.cardoso.roomexample.data.dao.PasesalidaDao
import dev.cardoso.roomexample.data.database.VehiculoDatabase
import dev.cardoso.roomexample.data.entities.PasesalidaDataToEntityMapper
import dev.cardoso.roomexample.data.entities.PasesalidaEntityToDataMapper
import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity
import io.reactivex.Flowable

class PasesalidaLocalImpl(
    database: VehiculoDatabase,
    private val entityToDataMapper: PasesalidaEntityToDataMapper,
    private val dataToEntityMapper: PasesalidaDataToEntityMapper
    ): PasesalidaDataStore {

    private val dao: PasesalidaDao = database.getPasesalidaDao()

    override fun getPasesalida(): Flowable<PasesalidaSourceEntity> {
        return dao.getAllPaseSalida().map {
            dataToEntityMapper.mapToEntity(it)
        }
    }


    fun savePasesalida(it: PasesalidaSourceEntity) {
        dao.saveAllPaseSalida(
            it.pasesalida.map {pase ->
                entityToDataMapper.mapPasesalidaToData(pase)
            })
    }


}
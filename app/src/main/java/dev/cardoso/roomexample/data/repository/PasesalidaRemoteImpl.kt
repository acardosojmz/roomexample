package dev.cardoso.roomexample.data.repository

import dev.cardoso.roomexample.data.api.PasesalidaEndPoint
import dev.cardoso.roomexample.data.entities.PasesalidaDataToEntityMapper
import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity

import io.reactivex.Flowable

class PasesalidaRemoteImpl constructor(private val api:PasesalidaEndPoint): PasesalidaDataStore {

    private val pasesalidaMapper =  PasesalidaDataToEntityMapper()

    override fun getPasesalida(): Flowable<PasesalidaSourceEntity> {
        return api.listarpasesalida().map { pasesalidaMapper.mapToEntity(it) }
    }

}
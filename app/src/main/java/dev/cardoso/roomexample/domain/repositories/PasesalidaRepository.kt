package dev.cardoso.roomexample.domain.repositories

import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity
import io.reactivex.Flowable


interface PasesalidaRepository {

    fun getPasesalida(): Flowable<PasesalidaSourceEntity>
    fun getLocalPasesalida(): Flowable<PasesalidaSourceEntity>
    fun getRemotePasesalida(): Flowable<PasesalidaSourceEntity>

}
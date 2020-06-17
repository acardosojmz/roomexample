package dev.cardoso.roomexample.data.repository

import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity
import io.reactivex.Flowable

interface PasesalidaDataStore{
    fun getPasesalida(): Flowable<PasesalidaSourceEntity>
}
package dev.cardoso.roomexample.data.repository

import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity
import dev.cardoso.roomexample.domain.repositories.PasesalidaRepository
import io.reactivex.Flowable

class PasesalidaRepositoryImpl
    (private val remote: PasesalidaRemoteImpl,
     private val local: PasesalidaLocalImpl) : PasesalidaRepository {

    override fun getLocalPasesalida(): Flowable<PasesalidaSourceEntity> {
        return local.getPasesalida()
    }

    override fun getRemotePasesalida(): Flowable<PasesalidaSourceEntity> {
        return remote.getPasesalida()
    }

    override fun getPasesalida(): Flowable<PasesalidaSourceEntity> {
        val updateNewsFlowable = remote.getPasesalida()
        return local.getPasesalida()
            .mergeWith(updateNewsFlowable.doOnNext{
                    remotePasesalida -> local.savePasesalida(remotePasesalida)
            })
    }
}
package dev.cardoso.roomexample.domain.usecase

import dev.cardoso.roomexample.domain.common.BaseFlowableUseCase
import dev.cardoso.roomexample.domain.common.FlowableRxTransformer
import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity
import dev.cardoso.roomexample.domain.repositories.PasesalidaRepository
import io.reactivex.Flowable

class GetPasesalidaUseCase
    (
    private val transformer: FlowableRxTransformer<PasesalidaSourceEntity>,
    private val repositories: PasesalidaRepository
    ): BaseFlowableUseCase<PasesalidaSourceEntity>(transformer){

    override fun createFlowable(data: Map<String, Any>?): Flowable<PasesalidaSourceEntity> {
        return repositories.getPasesalida()
    }

    fun getPasesalida(): Flowable<PasesalidaSourceEntity> {
        val data = HashMap<String, String>()
        return single(data)
    }
}
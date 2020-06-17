package dev.cardoso.roomexample.domain.usecase

import dev.cardoso.roomexample.domain.common.BaseFlowableUseCase
import dev.cardoso.roomexample.domain.common.FlowableRxTransformer
import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity
import dev.cardoso.roomexample.domain.repositories.PasesalidaRepository
import io.reactivex.Flowable

class GetRemotePasesalidaUseCase
    (
    transformer: FlowableRxTransformer<PasesalidaSourceEntity>,
    private val repositories: PasesalidaRepository
    ): BaseFlowableUseCase<PasesalidaSourceEntity>(transformer){

    companion object {
        private const val PARAM_FILE_NEWS_ENTITY = "pasesalida"
    }

    override fun createFlowable(data: Map<String, Any>?): Flowable<PasesalidaSourceEntity> {
        return repositories.getPasesalida()
    }

    fun getPasesalida(): Flowable<PasesalidaSourceEntity> {
        val data = HashMap<String, String>()
        return single(data)
    }


}
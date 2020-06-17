package dev.cardoso.roomexample.presentation.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import dev.cardoso.roomexample.domain.common.Mapper
import dev.cardoso.roomexample.domain.entities.PasesalidaSourceEntity
import dev.cardoso.roomexample.domain.usecase.GetPasesalidaUseCase
import dev.cardoso.roomexample.presentation.common.BaseViewModel
import dev.cardoso.roomexample.presentation.entities.Data
import dev.cardoso.roomexample.presentation.entities.Error
import dev.cardoso.roomexample.presentation.entities.PasesalidaSource
import dev.cardoso.roomexample.presentation.entities.Status

class PasesalidaViewModel(private val getPasesalidaUseCase: GetPasesalidaUseCase,
                    private val mapper: Mapper<PasesalidaSourceEntity, PasesalidaSource>
) : BaseViewModel() {

    companion object {
        private val TAG = "viewmodel"
    }

    var mPasesalida = MutableLiveData<Data<PasesalidaSource>>()

    fun fetchPasesalida() {
        val disposable = getPasesalidaUseCase.getPasesalida()
            .flatMap { mapper.Flowable(it) }
            .subscribe({ response ->
                Log.d(TAG, "On Next Called")
                mPasesalida.value = Data(responseType = Status.SUCCESSFUL, data = response)
            }, { error ->
                Log.d(TAG, "On Error Called")
                mPasesalida.value = Data(responseType = Status.ERROR, error = Error (error.message))
            }, {
                Log.d(TAG, "On Complete Called")
            })

        addDisposable(disposable)
    }

    fun getPasesalidaLiveData() = mPasesalida
}
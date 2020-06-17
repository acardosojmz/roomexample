package dev.cardoso.roomexample.presentation.di

import androidx.room.Room
import dev.cardoso.roomexample.data.api.PasesalidaEndPoint
import dev.cardoso.roomexample.data.database.VehiculoDatabase
import dev.cardoso.roomexample.data.entities.PasesalidaDataToEntityMapper
import dev.cardoso.roomexample.data.entities.PasesalidaEntityToDataMapper
import dev.cardoso.roomexample.data.repository.PasesalidaLocalImpl
import dev.cardoso.roomexample.data.repository.PasesalidaRemoteImpl
import dev.cardoso.roomexample.data.repository.PasesalidaRepositoryImpl
import dev.cardoso.roomexample.domain.usecase.GetPasesalidaUseCase
import dev.cardoso.roomexample.presentation.common.AsyncFlowableTransformer
import dev.cardoso.roomexample.presentation.network.createNetworkClient
import dev.cardoso.roomexample.presentation.ui.PasesalidaViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel


import org.koin.dsl.module

val mRepositoryModules = module {
    single { PasesalidaRemoteImpl(get())}
    single {
        PasesalidaLocalImpl(get(), PasesalidaEntityToDataMapper() ,
            PasesalidaDataToEntityMapper() )
    }
    single { PasesalidaRepositoryImpl(get(),
        get())}
}

val mUseCaseModules = module {
    factory {
        GetPasesalidaUseCase(AsyncFlowableTransformer(), get()) }
}

val mNetworkModules = module {
    single  { createNetworkClient(BASE_URL).create(PasesalidaEndPoint::class.java) }
}

val mLocalModules = module {
    single { Room.databaseBuilder(androidApplication(),
        VehiculoDatabase::class.java, "vehiculos").build() }
}


val mViewModels = module {
    viewModel {
        PasesalidaViewModel ( get(),get())
    }
}


private const val BASE_URL = "https://transportes.ceoaxaca.org.mx/api/"

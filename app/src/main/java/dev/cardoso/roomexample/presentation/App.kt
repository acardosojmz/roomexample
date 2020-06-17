package dev.cardoso.roomexample.presentation

import android.app.Application
import dev.cardoso.roomexample.presentation.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        loadKoin()
    }

    private fun loadKoin() {
        startKoin {
            androidContext(this@App)

            modules(listOf(mNetworkModules,
                mRepositoryModules,
                mUseCaseModules,
                mLocalModules,
                mViewModels)
            )
        }//--- End startKoin
    }
}
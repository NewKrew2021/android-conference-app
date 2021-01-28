package com.survivalcoding.ifkakao

import android.app.Application
import com.survivalcoding.ifkakao.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ConferenceApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ConferenceApplication)
            modules(viewModelModule)
            modules(repositoryModule)
            modules(networkModule)
            modules(remoteDataSourceModule)
            modules(localDataSourceModule)
        }
    }
}
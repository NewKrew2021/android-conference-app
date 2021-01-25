package com.survivalcoding.ifkakao.di

import com.survivalcoding.ifkakao.data.remote.datasource.RemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { RemoteDataSource(get()) }
}
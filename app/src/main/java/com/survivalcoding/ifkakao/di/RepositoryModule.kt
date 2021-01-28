package com.survivalcoding.ifkakao.di

import com.survivalcoding.ifkakao.data.repository.ConferenceRepository
import org.koin.dsl.module


val repositoryModule = module {
    single { ConferenceRepository(get(), get()) }
}
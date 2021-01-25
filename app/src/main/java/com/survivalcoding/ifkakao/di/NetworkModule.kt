package com.survivalcoding.ifkakao.di

import com.survivalcoding.ifkakao.data.remote.api.IfKakaoApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


val networkModule = module {
    single<IfKakaoApi>{
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/junsuk5/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(IfKakaoApi::class.java)
    }
}
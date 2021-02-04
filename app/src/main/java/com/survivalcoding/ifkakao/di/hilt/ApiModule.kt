package com.survivalcoding.ifkakao.di.hilt

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.survivalcoding.ifkakao.data.remote.api.IfKakaoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object ApiModule {

    @Singleton
    @Provides
    fun provideIfKakaoApi() =
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/junsuk5/mock_json/main/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(IfKakaoApi::class.java)
}
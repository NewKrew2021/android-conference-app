package com.survivalcoding.ifkakao.di.hilt

import com.survivalcoding.ifkakao.data.remote.api.IfKakaoApi
import com.survivalcoding.ifkakao.data.remote.datasource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(
        ifKakaoApi: IfKakaoApi
    ): RemoteDataSource {
        return RemoteDataSource(ifKakaoApi)
    }
}
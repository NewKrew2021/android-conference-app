package com.survivalcoding.ifkakao.di.hilt

import com.survivalcoding.ifkakao.data.local.datasource.LocalDataSource
import com.survivalcoding.ifkakao.data.remote.datasource.RemoteDataSource
import com.survivalcoding.ifkakao.data.repository.ConferenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) : ConferenceRepository {
        return ConferenceRepository(localDataSource, remoteDataSource)
    }
}
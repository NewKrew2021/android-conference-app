package com.survivalcoding.ifkakao.di.hilt

import com.survivalcoding.ifkakao.data.local.database.FavoriteDao
import com.survivalcoding.ifkakao.data.local.datasource.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(
        favoriteDao: FavoriteDao
    ): LocalDataSource {
        return LocalDataSource(favoriteDao)
    }
}
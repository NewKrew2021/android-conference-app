package com.survivalcoding.ifkakao.di.hilt

import android.content.Context
import androidx.room.Room
import com.survivalcoding.ifkakao.data.local.database.AppDataBase
import com.survivalcoding.ifkakao.data.local.database.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
internal object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "if_kakao.db")
            .fallbackToDestructiveMigration().build()
    }
    
    @Provides
    @Singleton
    fun provideFavoriteDao(appDataBase: AppDataBase) : FavoriteDao {
        return appDataBase.favoriteDao()
    }
}
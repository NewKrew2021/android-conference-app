package com.survivalcoding.ifkakao.di

import androidx.room.Room
import com.survivalcoding.ifkakao.data.local.database.IfKakaoDatabase
import com.survivalcoding.ifkakao.data.local.datasource.LocalDataSource
import org.koin.dsl.module

val localDataSourceModule = module {
    single {
        Room.databaseBuilder(get(), IfKakaoDatabase::class.java, "if_kakao.db")
            .fallbackToDestructiveMigration().build()
    }

    single { get<IfKakaoDatabase>().ifKakaoDao() }
    single { LocalDataSource(get()) }
}
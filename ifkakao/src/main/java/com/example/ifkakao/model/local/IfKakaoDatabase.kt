package com.example.ifkakao.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteSession::class], version = 1)
abstract class IfKakaoDatabase : RoomDatabase() {
    abstract fun sessionDao(): SessionDao
}
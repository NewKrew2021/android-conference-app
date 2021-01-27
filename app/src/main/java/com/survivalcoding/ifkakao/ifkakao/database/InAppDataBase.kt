package com.survivalcoding.ifkakao.ifkakao.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteTable::class], version = 1)
abstract class InAppDataBase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}
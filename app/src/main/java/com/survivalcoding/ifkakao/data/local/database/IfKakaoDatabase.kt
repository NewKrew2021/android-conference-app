package com.survivalcoding.ifkakao.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.survivalcoding.ifkakao.data.model.entity.Favorite

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class IfKakaoDatabase : RoomDatabase() {

    abstract fun ifKakaoDao() : FavoriteDao
}
package com.survivalcoding.ifkakao.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.survivalcoding.ifkakao.room.dao.FavoriteDao
import com.survivalcoding.ifkakao.room.table.Favorite

@Database(entities = [Favorite::class], version = 1)
abstract
class AppDatabase : RoomDatabase() {
    abstract fun favoriteDado() : FavoriteDao
    companion object {
        @Volatile private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: buildDatabase(context).also{
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "Room.db").build()
    }
}


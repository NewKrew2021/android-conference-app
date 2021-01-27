package com.jayden.ifkakaoclone.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favorite::class], version = 1)
abstract class FavoriteRoomDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao

    companion object {
        // 만약 앱이 싱글 프로세스로 동작한다면, AppDatabase를 초기화하는 코드를 싱글톤 디자인 패턴으로 작성해야 한다.
        // 각 RoomDatabase 인스턴스는 상당히 비싸며, 싱글 프로세스에서 다수의 인스턴스에 접근하는 경우는 드물다.
        @Volatile
        private var INSTANCE: FavoriteRoomDatabase? = null

        fun getDatabase(context: Context): FavoriteRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteRoomDatabase::class.java,
                    "favorite_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
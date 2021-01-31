package com.survivalcoding.ifkakao.repository

import android.content.Context
import androidx.room.Room
import com.survivalcoding.ifkakao.db.AppDatabase
import com.survivalcoding.ifkakao.db.Favorites

class FavoritesRepository(context: Context) {


    private val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "favorites.db"
    ).build()

    suspend fun getData(): List<Int> {
        return db.favoritesDao().getAll()
    }

    suspend fun insert(id: Int) {
        db.favoritesDao().insert(Favorites(id))
    }

    suspend fun remove(id: Int) {
        db.favoritesDao().delete((Favorites(id)))
    }

}
package com.survivalcoding.ifkakao.second.model.favorite.repository

import android.content.Context
import androidx.room.Room
import com.survivalcoding.ifkakao.second.model.favorite.database.AppDatabase
import com.survivalcoding.ifkakao.second.model.favorite.database.Favorite

class FavoriteRepository(context: Context) {
    private val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "favorite.db"
    ).allowMainThreadQueries().build()

    fun getAll(): List<Favorite> = db.favoriteDao().getAll()

    suspend fun insert(favorite: Favorite) {
        db.favoriteDao().insert(favorite)
    }
}
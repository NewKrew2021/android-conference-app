package com.survivalcoding.ifkakao.second.model.favorite.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.survivalcoding.ifkakao.second.model.favorite.database.AppDatabase
import com.survivalcoding.ifkakao.second.model.favorite.database.Favorite

class FavoriteRepository(context: Context) {
    private val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "favorite.db"
    ).allowMainThreadQueries().build()

    fun getAll(): LiveData<List<Favorite>> = db.favoriteDao().getAll()

    fun insert(favorite: Favorite) {
        db.favoriteDao().insert(favorite)
    }
}
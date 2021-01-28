package com.survivalcoding.ifkakao.ifkakao.repository

import android.content.Context
import androidx.room.Room
import com.survivalcoding.ifkakao.ifkakao.database.FavoriteTable
import com.survivalcoding.ifkakao.ifkakao.database.InAppDataBase

class FavoriteRepository(context: Context) {
    private val db = Room.databaseBuilder(
        context,
        InAppDataBase::class.java, "favorite.db"
    ).allowMainThreadQueries().build()

    suspend fun getFavoriteItem(): List<FavoriteTable> {
        return db.favoriteDao().getAll()
    }

    suspend fun insert(favoriteTable: FavoriteTable) {
        db.favoriteDao().insertIdx(favoriteTable)
    }

    suspend fun delete(favoriteTable: FavoriteTable) {
        db.favoriteDao().deleteIdx(favoriteTable)
    }

    suspend fun isFavoriteSession(idx: Int): Boolean {
        db.favoriteDao().isFavoriteSession(idx)?.let { return true }
        return false
    }
}
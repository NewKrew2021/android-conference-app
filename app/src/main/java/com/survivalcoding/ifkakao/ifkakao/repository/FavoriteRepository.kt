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

    fun getFavoriteItem(): List<FavoriteTable> {
        return db.favoriteDao().getAll()
    }

    fun insert(favoriteTable: FavoriteTable) {
        db.favoriteDao().insertIdx(favoriteTable)
    }

    fun delete(favoriteTable: FavoriteTable) {
        db.favoriteDao().deleteIdx(favoriteTable)
    }

    fun isFavoriteSesstion(idx: Int): Boolean {
        db.favoriteDao().isFavoriteSession(idx)?.let { return true }
        return false
    }
}
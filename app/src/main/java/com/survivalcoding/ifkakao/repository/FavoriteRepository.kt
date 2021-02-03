package com.survivalcoding.ifkakao.repository

import android.content.Context
import com.survivalcoding.ifkakao.room.AppDatabase
import com.survivalcoding.ifkakao.room.table.Favorite

class FavoriteRepository(val context: Context) {

    suspend fun insert(favorite: Favorite) {
        AppDatabase.getInstance(context).favoriteDado().insert(favorite)
    }

    fun getAllFavoriteList() = AppDatabase.getInstance(context).favoriteDado().getAll()


    suspend fun getFavoriteWithIdx(idx: Int) = AppDatabase.getInstance(context).favoriteDado().getFavoriteWithColumn(idx)


}
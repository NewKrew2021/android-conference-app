package com.survivalcoding.ifkakao.data.local.datasource

import com.survivalcoding.ifkakao.data.local.database.FavoriteDao
import com.survivalcoding.ifkakao.data.model.entity.Favorite


class LocalDataSource(private val favoriteDao: FavoriteDao) {

    suspend fun insertFavoriteSession(favorite: Favorite) {
        return favoriteDao.insertFavoriteSession(favorite)
    }

    suspend fun deleteFavoriteSessionById(id: Int) {
        return favoriteDao.deleteFavoriteSessionById(id)
    }

    suspend fun getAllFavoriteSessionId(): List<Int> {
        return favoriteDao.getAllFavoriteSessionId()
    }
}
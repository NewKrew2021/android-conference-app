package com.example.ifkakao.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.ifkakao.model.local.FavoriteSession
import com.example.ifkakao.model.local.IfKakaoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(context: Context) {
    private val db =
        Room.databaseBuilder(context, IfKakaoDatabase::class.java, DATABASE_NAME).build()

    suspend fun getAllFavoriteSessions(): LiveData<List<FavoriteSession>> =
        withContext(Dispatchers.IO) {
            db.sessionDao().getAllFavoriteSessions()
        }

    suspend fun findBySessionIndex(sessionIndex: Int): FavoriteSession =
        withContext(Dispatchers.IO) {
            db.sessionDao().findBySessionIndex(sessionIndex)
        }

    suspend fun addFavoriteSession(sessionIndex: Int) = withContext(Dispatchers.IO) {
        db.sessionDao()
            .addFavoriteSession(FavoriteSession(sessionIndex = sessionIndex, isFavorite = true))
    }

    suspend fun deleteFavoriteSession(favoriteSession: FavoriteSession) =
        withContext(Dispatchers.IO) {
            db.sessionDao().delete(favoriteSession)
        }

    companion object {
        const val DATABASE_NAME = "if_kakao.db"
    }
}
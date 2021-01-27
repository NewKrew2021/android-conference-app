package com.example.ifkakao.model

import androidx.lifecycle.LiveData
import com.example.ifkakao.model.local.FavoriteSession

interface Repository {
    suspend fun getConferenceData(): KakaoApiResponse

    suspend fun getAllFavoriteSessions(): LiveData<List<FavoriteSession>>

    suspend fun findFavoriteSessionByIndex(sessionIndex: Int): FavoriteSession

    suspend fun addFavoriteSession(sessionIndex: Int)

    suspend fun deleteFavoriteSession(favoriteSession: FavoriteSession)
}
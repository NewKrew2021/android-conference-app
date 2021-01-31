package com.example.ifkakao.model

import com.example.ifkakao.model.local.FavoriteSession

interface Repository {
    suspend fun getConferenceData(): KakaoApiResponse

    suspend fun getAllFavoriteSessions(): List<FavoriteSession>

    suspend fun findFavoriteSessionByIndex(sessionIndex: Int): FavoriteSession

    suspend fun addFavoriteSession(sessionIndex: Int)

    suspend fun deleteFavoriteSession(favoriteSession: FavoriteSession)
}
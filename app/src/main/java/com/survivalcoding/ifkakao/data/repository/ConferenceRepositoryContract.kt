package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.model.entity.Favorite
import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse

interface ConferenceRepositoryContract {

    suspend fun getAllSession(): ConferenceResponse

    suspend fun insertFavoriteSession(favorite: Favorite)

    suspend fun deleteFavoriteSessionById(id: Int)

    suspend fun getAllFavoriteSessionId(): List<Int>
}
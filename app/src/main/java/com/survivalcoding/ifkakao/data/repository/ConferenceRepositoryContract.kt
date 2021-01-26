package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse

interface ConferenceRepositoryContract {

    suspend fun getAllSession(): ConferenceResponse
}
package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse
import retrofit2.Response

interface ConferenceRepositoryContract {

    suspend fun getAllSession(): Response<ConferenceResponse>
}
package com.survivalcoding.ifkakao.data.remote.datasource

import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse
import retrofit2.Response

// API가 여러개면 여기서 모아서 전달
interface RemoteDataSourceContract {

    suspend fun getAllSession(): Response<ConferenceResponse>
}
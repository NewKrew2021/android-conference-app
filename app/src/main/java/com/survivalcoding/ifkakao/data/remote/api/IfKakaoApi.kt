package com.survivalcoding.ifkakao.data.remote.api

import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse
import retrofit2.Response
import retrofit2.http.GET

interface IfKakaoApi {

    @GET("conf/contents.json")
    suspend fun getAllSession(): Response<ConferenceResponse>
}
package com.survivalcoding.ifkakao.data.remote.api

import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import retrofit2.Call
import retrofit2.http.GET

interface IfKakaoApi {

    @GET("mock_json/main/conf/contents.json")
    fun getAllSession() : Call<List<ConferenceSessionResponse>>
}
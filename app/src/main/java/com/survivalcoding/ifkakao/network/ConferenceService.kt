package com.survivalcoding.ifkakao.network

import com.survivalcoding.ifkakao.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface ConferenceService {

    @GET("/junsuk5/mock_json/main/conf/contents.json")
    fun getConfData(): Call<Response>
}
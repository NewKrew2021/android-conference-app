package com.survivalcoding.ifkakao.network

import com.survivalcoding.ifkakao.extension.getRetrofitService
import com.survivalcoding.ifkakao.model.Requests
import retrofit2.http.GET

interface RetrofitService {
    @GET("/junsuk5/mock_json/main/conf/contents.json")
    suspend fun getData() : Requests

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }
}

object Network{
    val retrofitService = getRetrofitService()
}

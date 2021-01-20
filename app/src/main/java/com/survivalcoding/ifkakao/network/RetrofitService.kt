package com.survivalcoding.ifkakao.network

import com.survivalcoding.ifkakao.model.Requests
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("/junsuk5/mock_json/main/conf/contents.json")
    fun getData() : Call<Requests>

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }
}
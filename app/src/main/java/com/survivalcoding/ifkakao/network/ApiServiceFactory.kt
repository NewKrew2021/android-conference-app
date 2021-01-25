package com.survivalcoding.ifkakao.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceFactory {
    private const val JsonAPI_URL = "https://raw.githubusercontent.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(JsonAPI_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val ifKakaoService = retrofit.create(IfKakaoService::class.java)
}
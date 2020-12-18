package com.survivalcoding.ifkakao.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiServiceFactory {
    private const val IF_KAKAO_API_URL = "https://raw.githubusercontent.com/junsuk5/mock_json/main/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(IF_KAKAO_API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val ifKakaoService = retrofit.create(IfKakaoService::class.java)
}
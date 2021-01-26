package com.survivalcoding.ifkakao.second.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object JsonServiceFactory {
    private const val IF_KAKAO_API_BASE_URL =
        "https://raw.githubusercontent.com/junsuk5/mock_json/main/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(IF_KAKAO_API_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val contentService: ContentService = retrofit.create(ContentService::class.java)
}
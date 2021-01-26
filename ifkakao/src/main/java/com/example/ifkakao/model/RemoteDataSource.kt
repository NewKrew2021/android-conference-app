package com.example.ifkakao.model

import com.example.ifkakao.model.jsonformat.ConferenceData
import com.example.ifkakao.model.remote.IfKakaoService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RemoteDataSource {
    suspend fun getConferenceData(): Response<ConferenceData> = withContext(Dispatchers.IO) {
        val retrofit = Retrofit.Builder().baseUrl(IF_KAKAO_2020_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).build()
        val ifKakaoService = retrofit.create(IfKakaoService::class.java)
        ifKakaoService.getConferenceData().execute()
    }

    companion object {
        const val IF_KAKAO_2020_BASE_URL =
            "https://raw.githubusercontent.com/junsuk5/mock_json/main/"
    }
}
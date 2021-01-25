package com.example.ifkakao.model

import com.example.ifkakao.model.jsonformat.ConferenceData
import com.example.ifkakao.model.remote.IfKakaoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RemoteDataSource {
    fun getConferenceData(callback: (ConferenceData) -> Unit) {
        val retrofit = Retrofit.Builder().baseUrl(IF_KAKAO_2020_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).build()
        val ifKakaoService = retrofit.create(IfKakaoService::class.java)

        val result = ifKakaoService.getConferenceData()
        result.enqueue(object : Callback<ConferenceData> {
            override fun onResponse(
                call: Call<ConferenceData>,
                response: Response<ConferenceData>
            ) {
                response.body()?.let {
                    callback(it)
                }
            }

            override fun onFailure(call: Call<ConferenceData>, t: Throwable) {
                // TODO 실패 상황 처
            }
        })
    }

    companion object {
        const val IF_KAKAO_2020_BASE_URL =
            "https://raw.githubusercontent.com/junsuk5/mock_json/main/"
    }
}
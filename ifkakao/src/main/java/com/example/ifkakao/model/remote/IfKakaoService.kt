package com.example.ifkakao.model.remote

import com.example.ifkakao.model.jsonformat.ConferenceData
import retrofit2.Call
import retrofit2.http.GET

interface IfKakaoService {
    @GET("conf/contents.json")
    fun getConferenceData(): Call<ConferenceData>
}
package com.survivalcoding.ifkakao.network

import com.survivalcoding.ifkakao.model.jsonModel.Conference
import retrofit2.Call
import retrofit2.http.GET

interface IfKakaoService {
    @GET("junsuk5/mock_json/main/conf/contents.json")
    fun getData(): Call<Conference>
}
package com.survivalcoding.ifkakao.network

import com.survivalcoding.ifkakao.model.jsonModel.Conference
import retrofit2.http.GET

interface IfKakaoService {
    @GET("junsuk5/mock_json/main/conf/contents.json")
    suspend fun getData(): Conference
}
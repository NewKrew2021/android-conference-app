package com.survivalcoding.ifkakao.ifkakao.repository

import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("contents.json")
    fun getContentsData(): Call<IfKakaoResponse>
}
package com.survivalcoding.ifkakao.network

import com.survivalcoding.ifkakao.model.ContentsResult
import retrofit2.Call
import retrofit2.http.GET

interface IfKakaoService {
    @GET("conf/contents.json")
    fun getContents(): Call<ContentsResult>
}
package com.survivalcoding.ifkakao.second.network

import com.survivalcoding.ifkakao.second.model.Contents
import retrofit2.Call
import retrofit2.http.GET

interface ContentService {
    @GET("conf/contents.json")
    fun getData(): Call<Contents>
}
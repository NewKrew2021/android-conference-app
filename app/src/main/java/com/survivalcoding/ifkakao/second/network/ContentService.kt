package com.survivalcoding.ifkakao.second.network

import com.survivalcoding.ifkakao.second.model.content.Contents
import retrofit2.http.GET

interface ContentService {
    @GET("conf/contents.json")
    suspend fun getData(): Contents
}
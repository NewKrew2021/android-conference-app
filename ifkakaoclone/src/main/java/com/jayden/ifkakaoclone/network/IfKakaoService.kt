package com.jayden.ifkakaoclone.network

import com.jayden.ifkakaoclone.view.main.model.SessionResult
import retrofit2.http.GET

interface IfKakaoService {
    @GET("conf/contents.json")
    suspend fun fetchContents(): SessionResult
}
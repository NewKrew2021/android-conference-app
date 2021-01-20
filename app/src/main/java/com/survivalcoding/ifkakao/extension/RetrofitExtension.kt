package com.survivalcoding.ifkakao.extension

import com.survivalcoding.ifkakao.network.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun getRetrofitService() : RetrofitService{
    val retrofit = Retrofit.Builder().baseUrl(RetrofitService.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create()).build()
    return retrofit.create(RetrofitService::class.java)
}

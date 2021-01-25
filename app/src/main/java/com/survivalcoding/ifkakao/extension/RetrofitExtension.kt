package com.survivalcoding.ifkakao.extension

import com.squareup.moshi.Moshi
import com.survivalcoding.ifkakao.adapter.TitleAdapter
import com.survivalcoding.ifkakao.network.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun getRetrofitService(): RetrofitService {
    val titleMoshi = Moshi.Builder().add(TitleAdapter()).build()
    val retrofit = Retrofit.Builder().baseUrl(RetrofitService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(titleMoshi)).build()

    return retrofit.create(RetrofitService::class.java)
}

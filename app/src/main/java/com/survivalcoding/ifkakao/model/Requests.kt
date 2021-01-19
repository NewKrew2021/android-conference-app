package com.survivalcoding.ifkakao.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.survivalcoding.ifkakao.model.conferenceData.Data

@JsonClass(generateAdapter = true)
data class Requests(
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "code")
    val code: Int,
    @Json(name = "data")
    val data: List<Data>,
    @Json(name = "errorMessage")
    val errorMessage: Any?
)
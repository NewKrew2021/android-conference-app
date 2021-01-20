package com.survivalcoding.ifkakao.data.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConferenceResponse(
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "code")
    val code: Int,
    @Json(name = "data")
    val `data`: List<ConferenceSessionResponse>,
    @Json(name = "errorMessage")
    val errorMessage: Any?
)
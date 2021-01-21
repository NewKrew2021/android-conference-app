package com.survivalcoding.ifkakao.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    val success: Boolean,
    val code: Int,
    val `data`: List<Session>?,
    val errorMessage: String?,
)
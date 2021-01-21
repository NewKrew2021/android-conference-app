package com.survivalcoding.ifkakao.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Speaker(
    val nameKo: String,
    val nameEn: String,
    val company: String?,
    val occupation: String,
)
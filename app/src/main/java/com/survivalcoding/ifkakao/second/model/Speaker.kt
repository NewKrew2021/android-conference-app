package com.survivalcoding.ifkakao.second.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Speaker(
    val company: String?,
    val contentsIdx: Int,
    val idx: Int,
    val nameEn: String,
    val nameKo: String,
    val occupation: String
)
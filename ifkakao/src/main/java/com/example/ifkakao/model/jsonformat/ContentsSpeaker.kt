package com.example.ifkakao.model.jsonformat


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContentsSpeaker(
    val company: String? = null,
    val contentsIdx: Int,
    val idx: Int,
    val nameEn: String,
    val nameKo: String,
    val occupation: String
)
package com.example.ifkakao.model.jsonformat


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Json(name = "MO_MAIN_IMAGE")
data class MobileMainImage(
    val contentsIdx: Int,
    val description: String,
    val fileSize: Int,
    val idx: Int,
    val mainYn: String,
    val type: String,
    val url: String
)
package com.example.ifkakao.model.jsonformat


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Json(name = "PC_MAIN_IMAGE")
data class PcMainImage(
    val contentsIdx: Int,
    val description: String,
    val fileSize: Int,
    val idx: Int,
    val mainYn: Boolean,
    val type: String,
    val url: String
)
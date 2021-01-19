package com.survivalcoding.ifkakao.model.conferenceData


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PcImage(
    @Json(name = "idx")
    val idx: Int,
    @Json(name = "contentsIdx")
    val contentsIdx: Int,
    @Json(name = "type")
    val type: String,
    @Json(name = "fileSize")
    val fileSize: Int,
    @Json(name = "url")
    val url: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "mainYn")
    val mainYn: String
)
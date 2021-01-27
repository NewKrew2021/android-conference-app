package com.survivalcoding.ifkakao.second.model.content


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinkFile(
    val contentsIdx: Int,
    val description: String,
    val fileSize: Int,
    val idx: Int,
    val mainYn: String,
    val type: String,
    val url: String
)
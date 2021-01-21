package com.survivalcoding.ifkakao.model.jsonModel

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PCIMAGE(
    val contentsIdx: Int,
    val description: String,
    val fileSize: Int,
    val idx: Int,
    val mainYn: String,
    val type: String,
    val url: String
)
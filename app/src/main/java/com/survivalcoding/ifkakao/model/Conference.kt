package com.survivalcoding.ifkakao.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Conference(
    val idx: Int,
    val title: String,
    val content: String?,
    val contentTag: String?,
    val field: String?,
)
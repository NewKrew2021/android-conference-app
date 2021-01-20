package com.survivalcoding.ifkakao.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TmpConference(
    val end: String,
    val link: String,
    val location: String,
    val name: String,
    val start: String
)
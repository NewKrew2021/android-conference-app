package com.survivalcoding.ifkakao.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MobileImage(
    val url: String
)
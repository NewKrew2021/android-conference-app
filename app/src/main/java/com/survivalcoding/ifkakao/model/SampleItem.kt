package com.survivalcoding.ifkakao.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SampleItem(
    val name: String,
    val location: String,
)
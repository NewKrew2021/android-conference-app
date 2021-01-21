package com.survivalcoding.ifkakao.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpeakerProfile(
    val url: String,
)
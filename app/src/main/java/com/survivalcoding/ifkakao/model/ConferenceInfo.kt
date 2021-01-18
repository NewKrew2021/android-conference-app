package com.survivalcoding.ifkakao.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConferenceInfo(
    val name: String,
    val link: String,
    val start: String,
    val end: String,
    val location: String,
    @Json(name = "cocoa-only")
    val cocoaOnly: Boolean? = null
)
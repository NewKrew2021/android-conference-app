package com.survivalcoding.ifkakao.first.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Conference(
        @Json(name = "cocoa-only")
        val cocoaOnly: Boolean?,
        val end: String,
        val link: String,
        val location: String,
        val name: String,
        val start: String
)
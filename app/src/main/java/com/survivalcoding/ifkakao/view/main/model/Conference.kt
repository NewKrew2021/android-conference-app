package com.survivalcoding.ifkakao.view.main.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Conference(
    @Json(name = "name")
    val name: String,
    @Json(name = "link")
    val link: String,
    @Json(name = "start")
    val start: String,
    @Json(name = "end")
    val end: String,
    @Json(name = "location")
    val location: String,
    @Json(name = "cocoa-only")
    val cocoaOnly: Boolean? = null,
)
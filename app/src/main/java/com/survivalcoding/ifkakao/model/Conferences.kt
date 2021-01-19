package com.survivalcoding.ifkakao.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Conferences(
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
    val cocoaOnly: Boolean?,
) : Parcelable



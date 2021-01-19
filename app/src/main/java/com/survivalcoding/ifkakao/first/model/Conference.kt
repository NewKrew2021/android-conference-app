package com.survivalcoding.ifkakao.first.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Conference(
        @Json(name = "cocoa-only")
        val cocoaOnly: Boolean?,
        val end: String,
        val link: String,
        val location: String,
        val name: String,
        val start: String
) : Parcelable
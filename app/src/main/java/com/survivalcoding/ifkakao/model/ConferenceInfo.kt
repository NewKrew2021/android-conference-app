package com.survivalcoding.ifkakao.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ConferenceInfo(
    val name: String,
    val link: String,
    val start: String,
    val end: String,
    val location: String,
    @Json(name = "cocoa-only")
    val cocoaOnly: Boolean? = null
) : Parcelable
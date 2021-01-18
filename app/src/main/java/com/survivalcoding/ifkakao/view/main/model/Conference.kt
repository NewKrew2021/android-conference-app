package com.survivalcoding.ifkakao.view.main.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@kotlinx.android.parcel.Parcelize
@JsonClass(generateAdapter = true)
data class Conference(
    val name: String,
    val link: String,
    val start: String,
    val end: String,
    val location: String,
    @Json(name = "cocoa-only")
    val cocoaOnly: Boolean? = null,
) : Parcelable {
    fun getPeriod(): String = "$start - $end"
}
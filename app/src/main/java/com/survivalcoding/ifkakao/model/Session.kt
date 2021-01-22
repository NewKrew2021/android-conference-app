package com.survivalcoding.ifkakao.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.survivalcoding.ifkakao.extension.transformTagsToNewline
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Session(
    val idx: Int,
    @Json(name = "title")
    val _title: String,
    val content: String,
    val contentTag: String?,
    val `field`: String?,
    val linkList: LinkList,
    @Json(name = "contentsSpeackerList")
    val contentsSpeakerList: List<Speaker>,
) : Parcelable {
    val title: String
        get() = _title.transformTagsToNewline()
}
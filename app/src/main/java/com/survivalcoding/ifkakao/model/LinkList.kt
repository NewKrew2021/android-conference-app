package com.survivalcoding.ifkakao.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LinkList(
    @Json(name = "MO_IMAGE")
    val mobileImage: List<MobileImage>,
    @Json(name = "SPEACKER_PROFILE")
    val speakerProfile: List<SpeakerProfile>,
    @Json(name = "VIDEO")
    val video: List<Video>,
) : Parcelable
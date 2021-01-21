package com.survivalcoding.ifkakao.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class SpeakerProfile(
    val url: String,
) : Parcelable
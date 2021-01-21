package com.survivalcoding.ifkakao.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Speaker(
    val nameKo: String,
    val nameEn: String,
    val company: String?,
    val occupation: String,
) : Parcelable
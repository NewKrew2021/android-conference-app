package com.jayden.ifkakaoclone.view.main.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ContentsSpeacker(
    val company: String?,
    val contentsIdx: Int,
    val idx: Int,
    val nameEn: String,
    val nameKo: String,
    val occupation: String
) : Parcelable
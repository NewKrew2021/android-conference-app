package com.survivalcoding.ifkakao.ifkakao.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContentsSpeacker(
    val company: String,
    val contentsIdx: Int,
    val idx: Int,
    val nameEn: String,
    val nameKo: String,
    val occupation: String
) : Parcelable
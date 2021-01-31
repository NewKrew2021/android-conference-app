package com.survivalcoding.ifkakao.model.jsonModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SPEACKERPROFILE(
    val contentsIdx: Int,
    val description: String,
    val fileSize: Int,
    val idx: Int,
    val mainYn: String,
    val type: String,
    val url: String
) : Parcelable
package com.survivalcoding.ifkakao.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass


@kotlinx.android.parcel.Parcelize
data class ConferenceAppFront(
    var videoLength: String,
    var field: String,
    var title: String,
    var imageUrl: String
) :
    Parcelable
package com.survivalcoding.ifkakao.model

import android.os.Parcelable


@kotlinx.android.parcel.Parcelize
data class ConferenceAppFront(var videoLength : String , var field : String, var title : String) :
    Parcelable
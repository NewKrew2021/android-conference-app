package com.survivalcoding.ifkakao.ifkakao.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Data(
    val categoryIdx: Int,
    val companyName: String,
    val content: String,
    val contentTag: String,
    val contentsSpeackerList: List<ContentsSpeacker>,
    val createdDateTime: String,
    val createdUserIdx: Int,
    val favoriteYn: String,
    val `field`: String,
    val idx: Int,
    val lastModifiedDateTime: String,
    val lastModifiedUserIdx: Int,
    val linkList: @RawValue LinkList,
    val newCountentsYn: String,
    val reservationDate: String,
    val reservationTime: String,
    val reservationUTC: Long,
    val reservationYn: String,
    val sessionType: String,
    val speackerName: String,
    val spotlightYn: String,
    val title: String,
    val updateCountentsYn: String,
    val videoYn: String
) : Parcelable
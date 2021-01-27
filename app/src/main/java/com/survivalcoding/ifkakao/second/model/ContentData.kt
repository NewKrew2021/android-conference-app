package com.survivalcoding.ifkakao.second.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContentData(
    val categoryIdx: Int,
    val companyName: String?,
    val content: String,
    val contentTag: String?,
    val contentsSpeackerList: List<Speaker>,
    val createdDateTime: String,
    val createdUserIdx: Int,
    val favoriteYn: String,
    val `field`: String,
    val idx: Int,
    val lastModifiedDateTime: String,
    val lastModifiedUserIdx: Int,
    val linkList: LinkList,
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
)
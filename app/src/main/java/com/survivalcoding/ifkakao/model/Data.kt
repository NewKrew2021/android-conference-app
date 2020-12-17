package com.survivalcoding.ifkakao.model

data class Data(
    val idx: Int,
    val createdUserIdx: Int,
    val createdDateTime: String,
    val lastModifiedUserIdx: Int,
    val lastModifiedDateTime: String,
    val categoryIdx: Int,
    val title: String,
    val content: String,
    val contentTag: String,
    val reservationDate: String,
    val reservationTime: String,
    val spotlightYn: String,
    val `field`: String,
    val sessionType: String,
    val linkList: LinkList,
    val contentsSpeackerList: List<ContentsSpeacker>,
    val favoriteYn: String,
    val newCountentsYn: String,
    val updateCountentsYn: String,
    val reservationYn: String,
    val reservationUTC: Long,
    val companyName: String,
    val speackerName: String,
    val videoYn: String
)
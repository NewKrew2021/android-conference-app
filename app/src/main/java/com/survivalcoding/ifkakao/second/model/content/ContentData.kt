package com.survivalcoding.ifkakao.second.model.content


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
) : MainViewType()

data class Header(val idx: Int) : MainViewType()
data class Footer(val idx: Int) : MainViewType()

sealed class MainViewType


// sealed class를 외부에 선언하면 Cannot access '<init>': it is private in 'MainViewType' 오류가 나와서 내부에 함께 선언
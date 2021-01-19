package com.survivalcoding.ifkakao.model.conferenceData


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "idx")
    val idx: Int,
    @Json(name = "createdUserIdx")
    val createdUserIdx: Int,
    @Json(name = "createdDateTime")
    val createdDateTime: String,
    @Json(name = "lastModifiedUserIdx")
    val lastModifiedUserIdx: Int,
    @Json(name = "lastModifiedDateTime")
    val lastModifiedDateTime: String,
    @Json(name = "categoryIdx")
    val categoryIdx: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "content")
    val content: String,
    @Json(name = "contentTag")
    val contentTag: String,
    @Json(name = "reservationDate")
    val reservationDate: String,
    @Json(name = "reservationTime")
    val reservationTime: String,
    @Json(name = "spotlightYn")
    val spotlightYn: String,
    @Json(name = "field")
    val field: String,
    @Json(name = "sessionType")
    val sessionType: String,
    @Json(name = "linkList")
    val linkList: LinkList,
    @Json(name = "contentsSpeackerList")
    val contentsSpeackerList: List<ContentsSpeacker>,
    @Json(name = "favoriteYn")
    val favoriteYn: String,
    @Json(name = "newCountentsYn")
    val newCountentsYn: String,
    @Json(name = "updateCountentsYn")
    val updateCountentsYn: String,
    @Json(name = "reservationYn")
    val reservationYn: String,
    @Json(name = "reservationUTC")
    val reservationUTC: Long,
    @Json(name = "companyName")
    val companyName: String,
    @Json(name = "speackerName")
    val speackerName: String,
    @Json(name = "videoYn")
    val videoYn: String
)
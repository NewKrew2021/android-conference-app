package com.example.ifkakao.model.jsonformat


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Session(
    val categoryIdx: Int,
    val companyName: String? = null,
    val content: String,
    val contentTag: String? = null,
    @Json(name = "contentsSpeackerList")
    val contentsSpeakerList: List<ContentsSpeaker>,
    val createdDateTime: String,
    val createdUserIdx: Int,
    val favoriteYn: String,
    val field: String,
    val idx: Int,
    val lastModifiedDateTime: String,
    val lastModifiedUserIdx: Int,
    val linkList: LinkList,
    @Json(name = "newCountentsYn")
    val newContentsYn: String,
    val reservationDate: String,
    val reservationTime: String,
    val reservationUTC: Long,
    val reservationYn: String,
    val sessionType: String,
    @Json(name = "speackerName")
    val speakerName: String,
    val spotlightYn: String,
    val title: String,
    @Json(name = "updateCountentsYn")
    val updateContentsYn: String,
    val videoYn: String
)
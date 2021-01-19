package com.example.ifkakao.model.jsonformat


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    val categoryIdx: Int,
    val companyName: String,
    val content: String,
    val contentTag: String,
    @Json(name = "contentsSpeackerList")
    val contentsSpeakerList: List<ContentsSpeaker>,
    val createdDateTime: String,
    val createdUserIdx: Int,
    val favoriteYn: Boolean,
    val field: String,
    val idx: Int,
    val lastModifiedDateTime: String,
    val lastModifiedUserIdx: Int,
    val linkList: LinkList,
    @Json(name = "newCountentsYn")
    val newContentsYn: Boolean,
    val reservationDate: String,
    val reservationTime: String,
    val reservationUTC: Long,
    val reservationYn: Boolean,
    val sessionType: String,
    @Json(name = "speackerName")
    val speakerName: String,
    val spotlightYn: Boolean,
    val title: String,
    @Json(name = "updateCountentsYn")
    val updateContentsYn: Boolean,
    val videoYn: Boolean
)
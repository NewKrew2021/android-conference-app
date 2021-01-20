package com.survivalcoding.ifkakao.data.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConferenceSessionResponse(
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
    val `field`: String,
    @Json(name = "sessionType")
    val sessionType: String,
    @Json(name = "linkList")
    val linkList: ConferenceLinkListResponse,
    @Json(name = "contentsSpeackerList")
    val contentsSpeakerList: List<ConferenceContentsSpeakerResponse>,
    @Json(name = "favoriteYn")
    val favoriteYn: String,
    @Json(name = "newCountentsYn")
    val newContentsYn: String,
    @Json(name = "updateCountentsYn")
    val updateContentsYn: String,
    @Json(name = "reservationYn")
    val reservationYn: String,
    @Json(name = "reservationUTC")
    val reservationUTC: Long,
    @Json(name = "companyName")
    val companyName: String? = null,
    @Json(name = "speackerName")
    val speakerName: String,
    @Json(name = "videoYn")
    val videoYn: String,
) {
    fun parseString(string: String) = string.replace("<br>", "\n")

    fun parseImageUrl(session: ConferenceSessionResponse) = session.linkList.moImage[0].url

    fun parseRunningTime(session: ConferenceSessionResponse) =
        session.linkList.video[0].description
}


package com.survivalcoding.ifkakao.data.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConferenceContentsSpeakerResponse(
    @Json(name = "idx")
    val idx: Int,
    @Json(name = "contentsIdx")
    val contentsIdx: Int,
    @Json(name = "nameKo")
    val nameKo: String,
    @Json(name = "nameEn")
    val nameEn: String,
    @Json(name = "company")
    val company: String? = null,
    @Json(name = "occupation")
    val occupation: String
) {
    fun getNonNullCompany() : String{
        return this.company!!
    }
}
package com.survivalcoding.ifkakao.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinkList(
    @Json(name = "MO_IMAGE")
    val mobileImage: List<MobileImage>,
    @Json(name = "SPEACKER_PROFILE")
    val speakerProfile: List<SpeakerProfile>,
)
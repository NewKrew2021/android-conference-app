package com.survivalcoding.ifkakao.data.model.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConferenceLinkListResponse(
    @Json(name = "FILE")
    val file: List<ConferenceDetailResponse>,
    @Json(name = "IMAGE")
    val image: List<ConferenceDetailResponse>,
    @Json(name = "WEB_URL")
    val webUrl: List<ConferenceDetailResponse>,
    @Json(name = "VIDEO")
    val video: List<ConferenceDetailResponse>,
    @Json(name = "PC_THUMBNAIL")
    val pcThumbnail: List<ConferenceDetailResponse>,
    @Json(name = "MO_THUMBNAIL")
    val moThumbnail: List<ConferenceDetailResponse>,
    @Json(name = "TALK_THUMBNAIL")
    val talkThumbnail: List<ConferenceDetailResponse>,
    @Json(name = "SPEACKER_PROFILE")
    val speakerProfile: List<ConferenceDetailResponse>,
    @Json(name = "PC_MAIN_IMAGE")
    val pcMainImage: List<ConferenceDetailResponse>,
    @Json(name = "MO_MAIN_IMAGE")
    val moMainImage: List<ConferenceDetailResponse>,
    @Json(name = "PC_IMAGE")
    val pcImage: List<ConferenceDetailResponse>,
    @Json(name = "MO_IMAGE")
    val moImage: List<ConferenceDetailResponse>,
    @Json(name = "SHARE_IMAGE")
    val shareImage: List<ConferenceDetailResponse>,
    @Json(name = "PC_SPOTLIGHT")
    val pcSpotlight: List<ConferenceDetailResponse>,
    @Json(name = "MO_SPOTLIGHT")
    val moSpotlight: List<ConferenceDetailResponse>
)
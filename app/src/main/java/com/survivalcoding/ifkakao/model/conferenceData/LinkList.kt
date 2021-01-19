package com.survivalcoding.ifkakao.model.conferenceData


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinkList(
    @Json(name = "FILE")
    val file: List<Any>,
    @Json(name = "IMAGE")
    val image: List<Any>,
    @Json(name = "WEB_URL")
    val webURL: List<Any>,
    @Json(name = "VIDEO")
    val video: List<Video>,
    @Json(name = "PC_THUMBNAIL")
    val pcThumbnail: List<Any>,
    @Json(name = "MO_THUMBNAIL")
    val moThumbnail: List<Any>,
    @Json(name = "TALK_THUMBNAIL")
    val talkThumbnail: List<Any>,
    @Json(name = "SPEACKER_PROFILE")
    val speackerProfile: List<SpeackerProfile>,
    @Json(name = "PC_MAIN_IMAGE")
    val pcMainImage: List<PcMainImage>,
    @Json(name = "MO_MAIN_IMAGE")
    val moMainImage: List<MoMainImage>,
    @Json(name = "PC_IMAGE")
    val pcImage: List<PcImage>,
    @Json(name = "MO_IMAGE")
    val moImage: List<MoImage>,
    @Json(name = "SHARE_IMAGE")
    val shareImage: List<ShareImage>,
    @Json(name = "PC_SPOTLIGHT")
    val pcSpotlight: List<PcSpotlight>,
    @Json(name = "MO_SPOTLIGHT")
    val moSpotlight: List<MoSpotlight>
)
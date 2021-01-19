package com.example.ifkakao.model.jsonformat


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinkList(
    @Json(name = "FILE")
    val file: List<Any>,
    @Json(name = "IMAGE")
    val image: List<Any>,
    @Json(name = "MO_IMAGE")
    val mobileImage: List<MobileImage>,
    @Json(name = "MO_MAIN_IMAGE")
    val mobileMainImage: List<MobileMainImage>,
    @Json(name = "MO_SPOTLIGHT")
    val mobileSpotlight: List<MobileSpotlight>,
    @Json(name = "MO_THUMBNAIL")
    val mobileThumbnail: List<Any>,
    @Json(name = "PC_IMAGE")
    val pcImage: List<PcImage>,
    @Json(name = "PC_MAIN_IMAGE")
    val pcMainImage: List<PcMainImage>,
    @Json(name = "PC_SPOTLIGHT")
    val pcSpotlight: List<PcSpotlight>,
    @Json(name = "PC_THUMBNAIL")
    val pcThumbnail: List<Any>,
    @Json(name = "SHARE_IMAGE")
    val shareImage: List<ShareImage>,
    @Json(name = "SPEACKER_PROFILE")
    val speakerProfile: List<SpeakerProfile>,
    @Json(name = "TALK_THUMBNAIL")
    val talkThumbnail: List<Any>,
    @Json(name = "VIDEO")
    val video: List<Video>,
    @Json(name = "WEB_URL")
    val webUrl: List<Any>
)
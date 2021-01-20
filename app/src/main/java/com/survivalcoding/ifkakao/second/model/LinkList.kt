package com.survivalcoding.ifkakao.second.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinkList(
    @Json(name = "FILE")
    val file: List<LinkFile>,
    @Json(name = "IMAGE")
    val image: List<LinkFile>,
    @Json(name = "MO_IMAGE")
    val moImage: List<LinkFile>,
    @Json(name = "MO_MAIN_IMAGE")
    val moMainImage: List<LinkFile>,
    @Json(name = "MO_SPOTLIGHT")
    val moSpotlight: List<LinkFile>,
    @Json(name = "MO_THUMBNAIL")
    val moThumbnail: List<LinkFile>,
    @Json(name = "PC_IMAGE")
    val pcImage: List<LinkFile>,
    @Json(name = "PC_MAIN_IMAGE")
    val pcMainImage: List<LinkFile>,
    @Json(name = "PC_SPOTLIGHT")
    val pcSpotlight: List<LinkFile>,
    @Json(name = "PC_THUMBNAIL")
    val pcThumbnail: List<LinkFile>,
    @Json(name = "SHARE_IMAGE")
    val shareImage: List<LinkFile>,
    @Json(name = "SPEACKER_PROFILE")
    val speackerProfile: List<LinkFile>,
    @Json(name = "TALK_THUMBNAIL")
    val talkThumnail: List<LinkFile>,
    @Json(name = "VIDEO")
    val video: List<LinkFile>,
    @Json(name = "WEB_URL")
    val webUrl: List<LinkFile>,
)
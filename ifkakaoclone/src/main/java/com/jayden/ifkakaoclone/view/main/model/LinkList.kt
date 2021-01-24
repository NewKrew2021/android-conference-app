package com.jayden.ifkakaoclone.view.main.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinkList(
    @Json(name = "FILE")
    val file: List<Link>,
    @Json(name = "IMAGE")
    val image: List<Link>,
    @Json(name = "MO_IMAGE")
    val moImage: List<Link>,
    @Json(name = "MO_MAIN_IMAGE")
    val moMainImage: List<Link>,
    @Json(name = "MO_SPOTLIGHT")
    val moSpotlight: List<Link>,
    @Json(name = "MO_THUMBNAIL")
    val moThumbnail: List<Link>,
    @Json(name = "PC_IMAGE")
    val pcImage: List<Link>,
    @Json(name = "PC_MAIN_IMAGE")
    val pcMainImage: List<Link>,
    @Json(name = "PC_SPOTLIGHT")
    val pcSpotlight: List<Link>,
    @Json(name = "PC_THUMBNAIL")
    val pcThumbnail: List<Any>,
    @Json(name = "SHARE_IMAGE")
    val shareImage: List<Link>,
    @Json(name = "SPEACKER_PROFILE")
    val speackerProfile: List<Link>,
    @Json(name = "TALK_THUMBNAIL")
    val talkThumbnail: List<Link>,
    @Json(name = "VIDEO")
    val video: List<Link>,
    @Json(name = "WEB_URL")
    val webUrl: List<Link>
)
package com.survivalcoding.ifkakao.model

data class LinkList(
    val FILE: List<Any>,
    val IMAGE: List<Any>,
    val MO_IMAGE: List<MOIMAGE>,
    val MO_MAIN_IMAGE: List<MOMAINIMAGE>,
    val MO_SPOTLIGHT: List<MOSPOTLIGHT>,
    val MO_THUMBNAIL: List<Any>,
    val PC_IMAGE: List<PCIMAGE>,
    val PC_MAIN_IMAGE: List<PCMAINIMAGE>,
    val PC_SPOTLIGHT: List<PCSPOTLIGHT>,
    val PC_THUMBNAIL: List<Any>,
    val SHARE_IMAGE: List<SHAREIMAGE>,
    val SPEACKER_PROFILE: List<SPEACKERPROFILE>,
    val TALK_THUMBNAIL: List<Any>,
    val VIDEO: List<VIDEO>,
    val WEB_URL: List<Any>
)
package com.survivalcoding.ifkakao.model

data class LinkList(
    val FILE: List<Any>,
    val IMAGE: List<Any>,
    val WEB_URL: List<Any>,
    val VIDEO: List<VIDEO>,
    val PC_THUMBNAIL: List<Any>,
    val MO_THUMBNAIL: List<Any>,
    val TALK_THUMBNAIL: List<Any>,
    val SPEACKER_PROFILE: List<SPEACKERPROFILE>,
    val PC_MAIN_IMAGE: List<PCMAINIMAGE>,
    val MO_MAIN_IMAGE: List<MOMAINIMAGE>,
    val PC_IMAGE: List<PCIMAGE>,
    val MO_IMAGE: List<MOIMAGE>,
    val SHARE_IMAGE: List<SHAREIMAGE>,
    val PC_SPOTLIGHT: List<PCSPOTLIGHT>,
    val MO_SPOTLIGHT: List<MOSPOTLIGHT>
)
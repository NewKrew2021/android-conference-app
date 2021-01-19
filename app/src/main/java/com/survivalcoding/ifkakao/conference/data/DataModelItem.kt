package com.survivalcoding.ifkakao.conference.data

import com.google.gson.annotations.SerializedName

data class DataModelItem(
    @SerializedName("cocoa-only")
    val cocoaOnly: Boolean? = null,
    val end: String,
    val link: String,
    val location: String,
    val name: String,
    val start: String
)
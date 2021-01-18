package com.survivalcoding.ifkakao.view.main.model


import com.google.gson.annotations.SerializedName

data class Conference(
    @SerializedName("name")
    val name: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("end")
    val end: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("cocoa-only")
    val cocoaOnly: Boolean? = null
)
package com.survivalcoding.ifkakao.first.model

import com.google.gson.annotations.SerializedName


data class Conference(
        @SerializedName(value = "cocoa-only")
        val cocoaOnly: Boolean?,
        val end: String?,
        val link: String?,
        val location: String?,
        val name: String?,
        val start: String?
)
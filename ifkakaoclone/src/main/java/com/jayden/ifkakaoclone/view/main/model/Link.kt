package com.jayden.ifkakaoclone.view.main.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Link(
    val contentsIdx: Int,
    val description: String,
    val fileSize: Int,
    val idx: Int,
    val mainYn: String,
    val type: String,
    val url: String
)
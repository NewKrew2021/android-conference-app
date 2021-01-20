package com.survivalcoding.ifkakao.second.model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Contents(
    val code: Int,
    val data: List<ContentData>,
    val success: Boolean,
    val errorMessage: String?
)
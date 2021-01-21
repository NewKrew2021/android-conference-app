package com.survivalcoding.ifkakao.ifkakao.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IfKakaoItem(
    val code: Int,
    val `data`: List<Data>,
    val errorMessage: Any?,
    val success: Boolean
)
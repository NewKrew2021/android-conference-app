package com.survivalcoding.ifkakao.model.jsonModel

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Conference(
    val success: Boolean,
    val code: Int,
    val `data`: List<Data>,
    val errorMessage: Any,
)
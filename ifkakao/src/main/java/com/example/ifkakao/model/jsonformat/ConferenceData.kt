package com.example.ifkakao.model.jsonformat


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConferenceData(
    val success: Boolean,
    val code: Int,
    val data: List<Session>,
    val errorMessage: String? = null,
)
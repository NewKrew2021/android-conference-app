package com.jayden.ifkakaoclone.view.main.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SessionResult(
    val code: Int,
    val data: List<Session> = listOf(),
    val errorMessage: String?,
    val success: Boolean
)
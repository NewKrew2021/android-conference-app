package com.survivalcoding.ifkakao.model

data class ContentsResult(
    val success: Boolean,
    val code: Int,
    val `data`: List<Data>,
    val errorMessage: Any?
)
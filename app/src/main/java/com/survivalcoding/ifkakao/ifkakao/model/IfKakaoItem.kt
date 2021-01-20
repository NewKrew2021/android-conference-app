package com.survivalcoding.ifkakao.ifkakao.model

data class IfKakaoItem(
    val code: Int,
    val `data`: List<Data>,
    val errorMessage: Any,
    val success: Boolean
)
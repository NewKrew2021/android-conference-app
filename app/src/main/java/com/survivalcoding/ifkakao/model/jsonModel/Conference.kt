package com.survivalcoding.ifkakao.model.jsonModel

data class Conference(
    val success: Boolean,
    val code: Int,
    val `data`: List<Data>,
    val errorMessage: Any,
)
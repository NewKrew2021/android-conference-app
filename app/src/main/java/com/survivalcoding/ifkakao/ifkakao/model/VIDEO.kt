package com.survivalcoding.ifkakao.ifkakao.model

data class VIDEO(
    val contentsIdx: Int,
    val description: String,
    val fileSize: Int,
    val idx: Int,
    val mainYn: String,
    val type: String,
    val url: String
)
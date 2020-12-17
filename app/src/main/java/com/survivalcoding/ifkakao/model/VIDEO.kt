package com.survivalcoding.ifkakao.model

data class VIDEO(
    val idx: Int,
    val contentsIdx: Int,
    val type: String,
    val fileSize: Int,
    val url: String,
    val description: String,
    val mainYn: String
)
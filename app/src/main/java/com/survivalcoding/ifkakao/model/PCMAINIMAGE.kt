package com.survivalcoding.ifkakao.model

data class PCMAINIMAGE(
    val idx: Int,
    val contentsIdx: Int,
    val type: String,
    val fileSize: Int,
    val url: String,
    val description: String,
    val mainYn: String
)
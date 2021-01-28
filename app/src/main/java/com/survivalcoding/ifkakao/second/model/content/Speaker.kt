package com.survivalcoding.ifkakao.second.model.content


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Speaker(
    val company: String?,
    val contentsIdx: Int,
    val idx: Int,
    val nameEn: String,
    val nameKo: String,
    val occupation: String
) : DetailViewType()

data class DetailHeader(val idx: Int) : DetailViewType()
data class DetailFooter(val idx: Int) : DetailViewType()

sealed class DetailViewType
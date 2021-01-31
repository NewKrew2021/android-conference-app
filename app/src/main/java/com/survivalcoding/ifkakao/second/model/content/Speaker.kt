package com.survivalcoding.ifkakao.second.model.content


import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Speaker(
    val company: String?,
    val contentsIdx: Int,
    val idx: Int,
    val nameEn: String,
    val nameKo: String,
    val occupation: String
) : DetailViewType(), Parcelable

data class DetailHeader(val idx: Int) : DetailViewType()
data class DetailFooter(val idx: Int) : DetailViewType()

sealed class DetailViewType
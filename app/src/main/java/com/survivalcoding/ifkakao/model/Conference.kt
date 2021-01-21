package com.survivalcoding.ifkakao.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import com.survivalcoding.ifkakao.extension.getStringExceptTags
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Conference(
    val idx: Int,
    var title: String,
    val content: String?,
    val contentTag: String?,
    val `field`: String?,
    val linkList: LinkList,
    val contentsSpeackerList: List<Speaker>,
) : Parcelable {
    fun trimData() {
        title = title.getStringExceptTags()
    }
}
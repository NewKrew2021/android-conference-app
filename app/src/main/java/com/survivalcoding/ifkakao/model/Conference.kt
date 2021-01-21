package com.survivalcoding.ifkakao.model

import com.squareup.moshi.JsonClass
import com.survivalcoding.ifkakao.extension.getStringExceptTags

@JsonClass(generateAdapter = true)
data class Conference(
    val idx: Int,
    var title: String,
    val content: String?,
    val contentTag: String?,
    val `field`: String?,
    val linkList: LinkList,
    val contentsSpeackerList: List<Speaker>,
) {
    fun trimData() {
        title = title.getStringExceptTags()
    }
}
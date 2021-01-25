package com.survivalcoding.ifkakao.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import com.survivalcoding.ifkakao.annotation.HTMLCompact

class TitleAdapter {

    @ToJson
    fun toJson(@HTMLCompact title: String) = title

    @FromJson
    @HTMLCompact
    fun fromJson(title: String): String {
        return title.replace("<br>", "\n")
    }

}
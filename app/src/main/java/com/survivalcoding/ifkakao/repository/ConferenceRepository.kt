package com.survivalcoding.ifkakao.repository

import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.jsonModel.Conference
import okhttp3.*
import java.io.IOException


object ConferenceRepository {

    val url = "https://raw.githubusercontent.com/junsuk5/mock_json/main/conf/contents.json"
    val client = OkHttpClient()
    val request = Request.Builder().url(url).build()
    private var _listData = mutableListOf<ConferenceAppFront>()
    val listData get() = _listData

    fun getData(callback: (List<ConferenceAppFront>) -> Unit) {


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                //에러 메세지 출력
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val body = response.body()?.string()
                    val gson = GsonBuilder().create()
                    var collectionType = object : TypeToken<Conference>() {}.type
                    val topData: Conference = gson.fromJson(body, collectionType)
                    for (i in 0..topData.data.size - 1) {
                        var length = topData.data[i].linkList.VIDEO[0].description
                        var field = topData.data[i].field
                        var titleTmp = topData.data[i].title
                        var imageUrl = topData.data[i].linkList.PC_IMAGE[0].url
                        var content = topData.data[i].content
                        var contentTag = topData.data[i].contentTag ?: ""
                        var contentsSpeackerList = topData.data[i].contentsSpeackerList
                        var speackerProfileList = topData.data[i].linkList.SPEACKER_PROFILE
                        var title = titleTmp.replace("<br>", "\n")
                        _listData.add(
                            ConferenceAppFront(
                                length,
                                field,
                                title,
                                imageUrl,
                                content,
                                contentTag,
                                contentsSpeackerList,
                                speackerProfileList,

                                )
                        )
                    }
                    callback(listData)
                }
                //
            }

        })

    }

}
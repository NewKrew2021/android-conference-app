package com.survivalcoding.ifkakao.repository


import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.jsonModel.Conference
import com.survivalcoding.ifkakao.network.ApiServiceFactory.ifKakaoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object ConferenceRepository {

    val url = "https://raw.githubusercontent.com/"

    //val client = OkHttpClient()
    // val request = Request.Builder().url(url).build()
    private var _listData = mutableListOf<ConferenceAppFront>()
    val listData get() = _listData

    fun getData(callback: (List<ConferenceAppFront>) -> Unit) {

        listData.clear()
        ifKakaoService.getData().enqueue(object : Callback<Conference> {
            override fun onResponse(
                call: Call<Conference>,
                response: Response<Conference>
            ) {
                response.body()?.let {

                    val gson = GsonBuilder().create()
                    var collectionType = object : TypeToken<Conference>() {}.type
                    for (i in 0..it.data.size - 1) {
                        var length = it.data[i].linkList.VIDEO[0].description
                        var field = it.data[i].field
                        var titleTmp = it.data[i].title
                        var imageUrl = it.data[i].linkList.PC_IMAGE[0].url
                        var content = it.data[i].content
                        var contentTag = it.data[i].contentTag ?: ""
                        var contentsSpeackerList = it.data[i].contentsSpeackerList
                        var speackerProfileList = it.data[i].linkList.SPEACKER_PROFILE
                        var spotlightYn = it.data[i].spotlightYn
                        var sessionType = it.data[i].sessionType
                        var videoUrl = it.data[i].linkList.VIDEO[0].url
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
                                spotlightYn,
                                sessionType,
                                videoUrl,
                            )
                        )

                    }
                    callback(listData)
                }
            }

            override fun onFailure(call: Call<Conference>, t: Throwable) {
            }
        })

    }

    /*

    fun getData(callback: (List<ConferenceAppFront>) -> Unit) {

        //listData.clear()

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
                        var spotlightYn = topData.data[i].spotlightYn
                        var sessionType = topData.data[i].sessionType
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
                                spotlightYn,
                                sessionType
                            )
                        )
                    }

                    callback(listData)
                }
                //
            }

        })

    }

     */

}
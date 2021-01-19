package com.survivalcoding.ifkakao.repository

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.survivalcoding.ifkakao.model.Conference
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.TmpConference
import com.survivalcoding.ifkakao.view.adapter.RecyclerAdapter
import okhttp3.*
import java.io.IOException
import java.util.logging.Level.parse
import kotlin.properties.Delegates


class ConferenceRepository {

    val url = "https://raw.githubusercontent.com/junsuk5/mock_json/main/conf/contents.json"
    val client = OkHttpClient()
    val request = Request.Builder().url(url).build()
    var _listData = mutableListOf<ConferenceAppFront>()
    val listData get() = _listData
    var isFinish ="1"
    //lateinit var tmpAdapter : RecyclerAdapter  //나중에 삭제,, 임시




    fun getData() {

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
                        var title = topData.data[i].title
                        //Log.d("로", "$length $field  $title")


                        _listData.add(ConferenceAppFront(length, field, title))
                    }
                }


               // tmpAdapter.submitList(null)
               // tmpAdapter.submitList(listData.toList())
               // tmpAdapter.notifyDataSetChanged()
                //Log.d("로그", "$listData ")
                //isFinish="changed"
            }

        })

    }





}
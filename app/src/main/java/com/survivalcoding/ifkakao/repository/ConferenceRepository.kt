package com.survivalcoding.ifkakao.repository

import android.util.Log
import com.survivalcoding.ifkakao.model.Response
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.network.ApiHelper
import com.survivalcoding.ifkakao.network.ConferenceService
import retrofit2.Call
import retrofit2.Callback

class ConferenceRepository : DefaultRepository {

    private val confService = ApiHelper.createApiByService(ConferenceService::class)

    override fun requestConfData(
        callback: (List<Session>) -> Unit
    ) {
        confService.getConfData().enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                response.body()?.data?.let {
                    callback.invoke(it)
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("RetrofitError", t.toString())
            }
        })
    }
}
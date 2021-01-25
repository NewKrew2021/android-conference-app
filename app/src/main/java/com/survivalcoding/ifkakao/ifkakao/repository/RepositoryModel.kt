package com.survivalcoding.ifkakao.ifkakao.repository

import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryModel : DefaultRepositoryModel {
    private val retrofitService = RetrofitFactory.service

    override fun getParsedIfKakaoResponse(callback: (IfKakaoResponse?) -> Unit) {
        retrofitService.getContentsData().enqueue(object : Callback<IfKakaoResponse> {
            override fun onResponse(
                call: Call<IfKakaoResponse>,
                response: Response<IfKakaoResponse>
            ) {
                response.body()?.let {
                    callback.invoke(it)
                }
            }

            override fun onFailure(call: Call<IfKakaoResponse>, t: Throwable) {
                callback.invoke(null)
            }
        })
    }
}
package com.survivalcoding.ifkakao.data

import com.survivalcoding.ifkakao.model.ContentsResult
import com.survivalcoding.ifkakao.network.ApiServiceFactory
import com.survivalcoding.ifkakao.network.IfKakaoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContentsRepository {

    private val ifKakaoService: IfKakaoService = ApiServiceFactory.ifKakaoService

    fun getContents(callback: (ContentsResult?) -> Unit) {
        ifKakaoService.getContents().enqueue(object : Callback<ContentsResult> {
            override fun onResponse(
                call: Call<ContentsResult>,
                response: Response<ContentsResult>
            ) {
                response.body()?.let {
                    callback.invoke(it)
                }
            }

            override fun onFailure(call: Call<ContentsResult>, t: Throwable) {
                callback.invoke(null)
            }
        })
    }

}
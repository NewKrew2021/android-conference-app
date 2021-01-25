package com.jayden.ifkakaoclone.data.repository

import android.util.Log
import com.jayden.ifkakaoclone.network.ApiServiceFactory
import com.jayden.ifkakaoclone.view.main.model.Session
import com.jayden.ifkakaoclone.view.main.model.SessionResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SessionRepository : Repository {

    private val ifKakaoService = ApiServiceFactory.ifKakaoService

    override fun fetchContents(callback: (List<Session>) -> Unit) {
        ifKakaoService.fetchContents().enqueue(object : Callback<SessionResult> {
            override fun onResponse(call: Call<SessionResult>, response: Response<SessionResult>) {
                val body = response.body()

                if (response.isSuccessful && body != null) {
                    callback.invoke(body.data)
                } else {
                    callback.invoke(listOf())

                    Log.d(javaClass.simpleName, body?.errorMessage ?: "Request Not Success")
                }
            }

            override fun onFailure(call: Call<SessionResult>, t: Throwable) {
                callback.invoke(listOf())

                Log.d(javaClass.simpleName, t.message ?: "Request Failure")
            }
        })
    }
}
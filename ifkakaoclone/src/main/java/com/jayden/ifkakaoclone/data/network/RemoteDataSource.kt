package com.jayden.ifkakaoclone.data.network

import android.util.Log
import com.jayden.ifkakaoclone.network.ApiServiceFactory
import com.jayden.ifkakaoclone.view.main.model.Session

class RemoteDataSource {
    private val ifKakaoService = ApiServiceFactory.ifKakaoService

    suspend fun fetchContents(): List<Session> {
        val result = ifKakaoService.fetchContents()

        return if (result.success) {
            result.data
        } else {
            Log.d(javaClass.simpleName, result.errorMessage ?: "Request Not Success")
            listOf()
        }
    }
}
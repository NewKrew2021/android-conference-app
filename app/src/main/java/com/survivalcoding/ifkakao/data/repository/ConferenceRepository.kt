package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse
import com.survivalcoding.ifkakao.data.remote.datasource.RemoteDataSource
import retrofit2.Response

class ConferenceRepository(private val remoteDataSource: RemoteDataSource) :
    ConferenceRepositoryContract {

    override suspend fun getAllSession(): Response<ConferenceResponse> {
        return remoteDataSource.getAllSession()
    }

}


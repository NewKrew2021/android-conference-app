package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse
import com.survivalcoding.ifkakao.data.remote.datasource.RemoteDataSource

class ConferenceRepository(private val remoteDataSource: RemoteDataSource) :
    ConferenceRepositoryContract {

    override suspend fun getAllSession(): ConferenceResponse = remoteDataSource.getAllSession()

}

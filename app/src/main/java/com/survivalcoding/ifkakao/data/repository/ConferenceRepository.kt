package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.local.datasource.LocalDataSource
import com.survivalcoding.ifkakao.data.model.entity.Favorite
import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse
import com.survivalcoding.ifkakao.data.remote.datasource.RemoteDataSource

class ConferenceRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    ConferenceRepositoryContract {

    override suspend fun getAllSession(): ConferenceResponse = remoteDataSource.getAllSession()

    override suspend fun insertFavoriteSession(favorite: Favorite) {
        localDataSource.insertFavoriteSession(favorite)
    }

    override suspend fun deleteFavoriteSessionById(id: Int) {
        localDataSource.deleteFavoriteSessionById(id)
    }

    override suspend fun getAllFavoriteSessionId(): List<Int> {
        return localDataSource.getAllFavoriteSessionId()

    }

}

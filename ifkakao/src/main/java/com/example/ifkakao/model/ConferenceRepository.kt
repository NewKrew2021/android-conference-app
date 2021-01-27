package com.example.ifkakao.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.ifkakao.model.jsonformat.ConferenceData
import com.example.ifkakao.model.local.FavoriteSession

sealed class KakaoApiResponse {
    class Success(val result: ConferenceData) : KakaoApiResponse()
    class Failure(val errorCode: Int) : KakaoApiResponse()
}

class ConferenceRepository(private val context: Context) : Repository {
    private val remoteDataSource = RemoteDataSource()
    private val localDataSource = LocalDataSource(context)

    override suspend fun getConferenceData(): KakaoApiResponse {
        val result = remoteDataSource.getConferenceData()
        return if (result.isSuccessful) {
            result.body()?.let { KakaoApiResponse.Success(it) }
                ?: KakaoApiResponse.Failure(
                    result.code()
                )
        } else {
            KakaoApiResponse.Failure(result.code())
        }
    }

    override suspend fun getAllFavoriteSessions(): LiveData<List<FavoriteSession>> {
        return localDataSource.getAllFavoriteSessions()
    }

    override suspend fun findFavoriteSessionByIndex(sessionIndex: Int): FavoriteSession {
        return localDataSource.findBySessionIndex(sessionIndex)
    }

    override suspend fun addFavoriteSession(sessionIndex: Int) {
        return localDataSource.addFavoriteSession(sessionIndex)
    }

    override suspend fun deleteFavoriteSession(favoriteSession: FavoriteSession) {
        return localDataSource.deleteFavoriteSession(favoriteSession)
    }
}
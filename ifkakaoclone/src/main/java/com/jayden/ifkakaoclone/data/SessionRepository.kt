package com.jayden.ifkakaoclone.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.jayden.ifkakaoclone.data.db.Favorite
import com.jayden.ifkakaoclone.data.db.FavoriteRoomDatabase
import com.jayden.ifkakaoclone.data.network.RemoteDataSource
import com.jayden.ifkakaoclone.view.main.model.Session
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SessionRepository(context: Context) : Repository {
    private val remoteDataSource = RemoteDataSource()
    private val localDataSource = FavoriteRoomDatabase.getDatabase(context)

    override suspend fun fetchContents(): List<Session> = remoteDataSource.fetchContents()

    override fun getFavorites(): LiveData<List<Favorite>> = localDataSource.favoriteDao().getFavorites()

    override suspend fun insertFavorite(favorite: Favorite) {
        withContext(Dispatchers.IO) {
            localDataSource.favoriteDao().insert(favorite)
        }
    }
}
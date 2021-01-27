package com.jayden.ifkakaoclone.data

import androidx.lifecycle.LiveData
import com.jayden.ifkakaoclone.data.db.Favorite
import com.jayden.ifkakaoclone.view.main.model.Session

interface Repository {
    suspend fun fetchContents(): List<Session>

    fun getFavorites(): LiveData<List<Favorite>>

    fun insertFavorite(favorite: Favorite)
}
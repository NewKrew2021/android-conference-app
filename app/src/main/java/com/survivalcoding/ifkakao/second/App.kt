package com.survivalcoding.ifkakao.second

import android.app.Application
import com.survivalcoding.ifkakao.second.model.content.repository.ContentRepository
import com.survivalcoding.ifkakao.second.model.favorite.repository.FavoriteRepository

class App : Application() {
    val repository = ContentRepository()
    val favoriteRepository by lazy {
        FavoriteRepository(applicationContext)
    }
}
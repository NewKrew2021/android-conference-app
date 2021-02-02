package com.survivalcoding.ifkakao

import android.app.Application
import com.survivalcoding.ifkakao.database.AppDatabase
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import com.survivalcoding.ifkakao.repository.LikeRepository

class App : Application() {
    val confRepository by lazy {
        ConferenceRepository()
    }
    val likeRepository by lazy {
        LikeRepository(AppDatabase.getDatabase(this).likeDao())
    }
}
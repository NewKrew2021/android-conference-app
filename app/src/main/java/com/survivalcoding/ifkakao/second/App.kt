package com.survivalcoding.ifkakao.second

import android.app.Application
import com.survivalcoding.ifkakao.second.model.repository.ContentRepository

class App : Application() {
    val repository = ContentRepository()
}
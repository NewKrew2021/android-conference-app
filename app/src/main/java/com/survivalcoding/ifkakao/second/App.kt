package com.survivalcoding.ifkakao.second

import android.app.Application
import com.survivalcoding.ifkakao.second.model.content.repository.ContentRepository

class App : Application() {
    val repository = ContentRepository()
}
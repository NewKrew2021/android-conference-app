package com.survivalcoding.ifkakao.first

import android.app.Application
import com.survivalcoding.ifkakao.first.model.repository.ConferenceRepository

class App : Application() {
    val repository = ConferenceRepository()
}
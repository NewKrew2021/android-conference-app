package com.survivalcoding.ifkakao

import android.app.Application
import com.survivalcoding.ifkakao.data.repository.ConferenceRepository

class App : Application() {
    val repository = ConferenceRepository()
}
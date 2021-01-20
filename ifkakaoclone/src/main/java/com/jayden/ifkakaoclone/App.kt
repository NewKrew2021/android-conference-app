package com.jayden.ifkakaoclone

import android.app.Application
import com.jayden.ifkakaoclone.data.repository.SessionRepository

class App : Application() {
    val repository by lazy {
        SessionRepository(applicationContext)
    }
}
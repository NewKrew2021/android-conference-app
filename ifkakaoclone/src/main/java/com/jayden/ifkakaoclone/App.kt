package com.jayden.ifkakaoclone

import android.app.Application
import com.jayden.ifkakaoclone.data.SessionRepository

class App : Application() {
    val repository: SessionRepository by lazy { SessionRepository() }
}
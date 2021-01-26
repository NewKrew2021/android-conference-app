package com.jayden.ifkakaoclone.data

import com.jayden.ifkakaoclone.view.main.model.Session

interface Repository {
    suspend fun fetchContents(): List<Session>
}
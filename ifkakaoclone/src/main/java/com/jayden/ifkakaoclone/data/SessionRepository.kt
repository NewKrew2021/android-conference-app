package com.jayden.ifkakaoclone.data

import com.jayden.ifkakaoclone.data.network.RemoteDataSource
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionRepository : Repository {
    private val remoteDataSource = RemoteDataSource()

    override suspend fun fetchContents(): List<Session> = remoteDataSource.fetchContents()
}
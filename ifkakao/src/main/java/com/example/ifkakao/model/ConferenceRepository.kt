package com.example.ifkakao.model

import com.example.ifkakao.model.jsonformat.ConferenceData

class ConferenceRepository : Repository {
    private val remoteDataSource = RemoteDataSource()

    override fun getConferenceData(callback: (ConferenceData) -> Unit) {
        remoteDataSource.getConferenceData {
            callback(it)
        }
    }
}
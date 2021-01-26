package com.survivalcoding.ifkakao.repository


import com.survivalcoding.ifkakao.network.Network

object ConferenceRepository : Repository {

    override suspend fun getRequests() = Network.retrofitService.getData()
}


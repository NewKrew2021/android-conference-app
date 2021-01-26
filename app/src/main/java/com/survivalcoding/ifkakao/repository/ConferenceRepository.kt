package com.survivalcoding.ifkakao.repository

import com.survivalcoding.ifkakao.network.ApiHelper
import com.survivalcoding.ifkakao.network.ConferenceService

class ConferenceRepository {

    private val confService = ApiHelper.createApiByService(ConferenceService::class)

    suspend fun requestConfData() = confService.getConfData()
}
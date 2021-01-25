package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse

interface ConferenceRepositoryContract {
    fun getAllSession(): List<ConferenceSessionResponse>
}
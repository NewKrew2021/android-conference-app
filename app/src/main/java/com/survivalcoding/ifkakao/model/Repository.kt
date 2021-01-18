package com.survivalcoding.ifkakao.model

interface Repository {
    fun getConferenceData(): List<ConferenceInfo>
}
package com.example.ifkakao.model

import com.example.ifkakao.model.jsonformat.ConferenceData

interface Repository {
    fun getConferenceData(): ConferenceData
}
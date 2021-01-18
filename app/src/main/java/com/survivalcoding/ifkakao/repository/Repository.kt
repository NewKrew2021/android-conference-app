package com.survivalcoding.ifkakao.repository

import com.survivalcoding.ifkakao.model.ConferenceItem

interface Repository {
    fun getConferenceList() : List<ConferenceItem>
}
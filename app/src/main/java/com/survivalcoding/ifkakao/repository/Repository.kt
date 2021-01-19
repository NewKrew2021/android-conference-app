package com.survivalcoding.ifkakao.repository

import com.survivalcoding.ifkakao.model.Conferences
import com.survivalcoding.ifkakao.model.Requests
import com.survivalcoding.ifkakao.model.conferenceData.Data

interface Repository {
    fun getConferenceList() : List<Conferences>

    fun getRequests() : List<Data>
}

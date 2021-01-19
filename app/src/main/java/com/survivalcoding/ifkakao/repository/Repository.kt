package com.survivalcoding.ifkakao.repository

import com.survivalcoding.ifkakao.model.Conferences

interface Repository {
    fun getConferenceList() : List<Conferences>
}
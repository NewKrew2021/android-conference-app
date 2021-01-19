package com.survivalcoding.ifkakao.repository


import com.survivalcoding.ifkakao.model.conferenceData.Data

interface Repository {
    fun getRequests(): List<Data>
}

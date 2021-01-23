package com.survivalcoding.ifkakao.model

import com.survivalcoding.ifkakao.model.jsonModel.ContentsSpeacker
import com.survivalcoding.ifkakao.model.jsonModel.SPEACKERPROFILE


data class ConferenceAppFront(
    var videoLength: String,
    var field: String,
    var title: String,
    var imageUrl: String,
    var content: String,
    var contentTag: String,
    var contentsSpeackerList: List<ContentsSpeacker>,
    var speackerProfileList: List<SPEACKERPROFILE>,
    var spotlightYn: String,
    var sessionType: String,
) : DetailRecyclerType

package com.survivalcoding.ifkakao.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.DetailRecyclerType
import com.survivalcoding.ifkakao.model.jsonModel.Conference
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ConferenceViewModel : ViewModel() {

    private var _listData = MutableLiveData<MutableList<ConferenceAppFront>>()
    val listData get() = _listData

    //var currentPosition = 0
    private var _singleData = MutableLiveData<ConferenceAppFront>()
    val singleData get() = _singleData
    private var _selectInterests = mutableSetOf<String>()
    val selectInterests get() = _selectInterests
    var nonChoice = true

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                parsingToConferenceAppFront(ConferenceRepository.getData())
            }
        }
    }

    fun parsingToConferenceAppFront(topData: Conference) {

        val tmpData = mutableListOf<ConferenceAppFront>()

        for (i in 0..topData.data.size - 1) {
            var length = topData.data[i].linkList.VIDEO[0].description
            var field = topData.data[i].field
            var titleTmp = topData.data[i].title
            var imageUrl = topData.data[i].linkList.PC_IMAGE[0].url
            var content = topData.data[i].content
            var contentTag = topData.data[i].contentTag ?: ""
            var contentsSpeackerList = topData.data[i].contentsSpeackerList
            var speackerProfileList = topData.data[i].linkList.SPEACKER_PROFILE
            var spotlightYn = topData.data[i].spotlightYn
            var sessionType = topData.data[i].sessionType
            var videoUrl = topData.data[i].linkList.VIDEO[0].url
            var id = topData.data[i].idx
            var title = titleTmp.replace("<br>", "\n")
            tmpData.add(
                ConferenceAppFront(
                    length,
                    field,
                    title,
                    imageUrl,
                    content,
                    contentTag,
                    contentsSpeackerList,
                    speackerProfileList,
                    spotlightYn,
                    sessionType,
                    videoUrl,
                    id
                )
            )
        }
        _listData.postValue(tmpData)
    }

    fun getHighlightData(): MutableList<ConferenceAppFront> {
        var tmpList = mutableListOf<ConferenceAppFront>()

        _listData.value?.let {

            for (i in 0..it.size - 1) {
                if (it.get(i).spotlightYn == "Y") tmpList.add(it.get(i))
            }
        }
        return tmpList
    }

    fun getRelativeData(data: String, id: Int): List<DetailRecyclerType> {
        var tmpList = listOf<DetailRecyclerType>()

        _listData.value?.let {
            tmpList = it.filter { it.field == data && it.id != id }.map { it as DetailRecyclerType }
                .toList()
        }
        return tmpList
    }

}
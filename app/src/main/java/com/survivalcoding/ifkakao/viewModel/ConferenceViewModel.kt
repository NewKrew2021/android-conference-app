package com.survivalcoding.ifkakao.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.DetailRecyclerType
import com.survivalcoding.ifkakao.model.jsonModel.Conference
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import com.survivalcoding.ifkakao.repository.FavoritesRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConferenceViewModel(application: Application) : AndroidViewModel(application) {

    private val favoritesRepository = FavoritesRepository(application.applicationContext)
    private var favoritesSet = mutableSetOf<Int>()

    private var _listData = MutableLiveData<MutableList<ConferenceAppFront>>()
    val listData get() = _listData

    // private var _singleData = MutableLiveData<ConferenceAppFront>()
    // val singleData get() = _singleData
    private var _selectInterests = mutableSetOf<String>()
    val selectInterests get() = _selectInterests
    var nonChoice = true

    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("log2", "데이터를 받아오는데 실패하였습니다.")
    }

    fun removeFavoritesItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            favoritesRepository.remove(id)
            favoritesSet.remove(id)
        }
    }

    fun addFavoritesItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            favoritesRepository.insert(id)
            favoritesSet.add(id)
        }
    }

    fun storeFavoritesData() {
        viewModelScope.launch(Dispatchers.IO) {
            favoritesSet = favoritesRepository.getData().toMutableSet()
        }
    }

    fun getFavoritesData(): List<ConferenceAppFront> {
        val tmpList = mutableListOf<ConferenceAppFront>()

        _listData.value?.let {
            for (i in 0 until it.size) {
                if (favoritesSet.contains(it[i].id)) tmpList.add(it[i])
            }
        }
        return tmpList.toList()
    }

    fun isExistFavorites(id: Int): Boolean {
        return favoritesSet.contains(id)
    }

    fun getData() {
        viewModelScope.launch(handler) {
            parsingToConferenceAppFront(ConferenceRepository.getData())
        }
    }

    private fun parsingToConferenceAppFront(topData: Conference) {

        val tmpData = mutableListOf<ConferenceAppFront>()

        for (i in 0..topData.data.size - 1) {
            val length = topData.data[i].linkList.VIDEO[0].description
            val field = topData.data[i].field
            val titleTmp = topData.data[i].title
            val imageUrl = topData.data[i].linkList.PC_IMAGE[0].url
            val content = topData.data[i].content
            val contentTag = topData.data[i].contentTag ?: ""
            val contentsSpeackerList = topData.data[i].contentsSpeackerList
            val speackerProfileList = topData.data[i].linkList.SPEACKER_PROFILE
            val spotlightYn = topData.data[i].spotlightYn
            val sessionType = topData.data[i].sessionType
            val videoUrl = topData.data[i].linkList.VIDEO[0].url
            val id = topData.data[i].idx
            val title = titleTmp.replace("<br>", "\n")
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
        val tmpList = mutableListOf<ConferenceAppFront>()

        _listData.value?.let {

            for (i in 0 until it.size) {
                if (it[i].spotlightYn == "Y") tmpList.add(it[i])
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
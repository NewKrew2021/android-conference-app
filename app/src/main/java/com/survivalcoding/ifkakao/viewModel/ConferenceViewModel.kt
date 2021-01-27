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
import kotlinx.coroutines.withContext

class ConferenceViewModel(application: Application) : AndroidViewModel(application) {

    private val favoritesRepository = FavoritesRepository(application.applicationContext)
    private var favoritesList = listOf<Int>()

    private var _listData = MutableLiveData<MutableList<ConferenceAppFront>>()
    val listData get() = _listData

    private var _singleData = MutableLiveData<ConferenceAppFront>()
    val singleData get() = _singleData
    private var _selectInterests = mutableSetOf<String>()
    val selectInterests get() = _selectInterests
    var nonChoice = true

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("log2", "데이터를 받아오는데 실패하였습니다.")
    }

    fun removeFavoritesItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            favoritesRepository.remove(id)
        }
    }

    fun addFavoritesItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            favoritesRepository.insert(id)
        }
    }

    suspend fun getFavoritesData() = withContext(Dispatchers.IO) {
        val tmpList = mutableListOf<ConferenceAppFront>()
        favoritesList = favoritesRepository.getData()

        _listData.value?.let {
            for (i in 0..it.size - 1) {
                if (favoritesList.contains(it.get(i).id)) tmpList.add(it.get(i))
            }
        }
        tmpList.toList()
    }

    fun isExistFavorites(id: Int): Boolean {
        return favoritesList.contains(id)
    }

    fun getData() {
        viewModelScope.launch(handler) {
            parsingToConferenceAppFront(ConferenceRepository.getData())
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
package com.survivalcoding.ifkakao.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.data.ContentsRepository
import com.survivalcoding.ifkakao.model.Data

class MainViewModel : ViewModel() {
    data class Action(val type: Type, val url: String) {
        enum class Type {
            VIDEO_PLAY
        }
    }

    private val contentsRepository = ContentsRepository()

    private val _selectedItem = MutableLiveData<Data>()
    val selectedItem: LiveData<Data> get() = _selectedItem

    private val _eventLiveData = MutableLiveData<Action>()
    val eventLiveData: LiveData<Action> get() = _eventLiveData

    fun getContents(): List<Data> = contentsRepository.contents?.data ?: emptyList()

    fun selectItem(item: Data) {
        _selectedItem.value = item
    }

    fun playMedia(url: String) {
        _eventLiveData.value = Action(Action.Type.VIDEO_PLAY, url)
    }
}
package com.survivalcoding.ifkakao.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.data.repository.ConferenceRepository
import com.survivalcoding.ifkakao.util.EMPTY_STRING
import kotlinx.coroutines.launch

class SessionViewModel(private val repository: ConferenceRepository) : ViewModel() {

    private val _conferenceData = MutableLiveData<List<ConferenceSessionResponse>>()
    val conferenceData: LiveData<List<ConferenceSessionResponse>>
        get() = _conferenceData

    private val _likeCheck = MutableLiveData<Boolean>()
    val likeCheck: LiveData<Boolean>
        get() = _likeCheck

    fun getConferenceData(filter: String) {
        viewModelScope.launch {
            val filteredData = if (filter == EMPTY_STRING) {
                repository.getAllSession().data
            } else {
                repository.getAllSession().data.filter {
                    filter.contains(it.field)
                }
            }
            _conferenceData.postValue(filteredData)
        }
    }

    fun setLikeCheck(state: Boolean) {
        _likeCheck.value = state
    }

    fun getFavoriteConferenceData() {
        viewModelScope.launch {
            _conferenceData.value = _conferenceData.value?.filter {
                repository.getAllFavoriteSessionId().contains(it.idx)
            }
        }

    }
}
package com.survivalcoding.ifkakao.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.data.repository.ConferenceRepository
import com.survivalcoding.ifkakao.extension.toLiveData
import com.survivalcoding.ifkakao.util.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(private val repository: ConferenceRepository) :
    ViewModel() {

    private val _conferenceData = MutableLiveData<List<ConferenceSessionResponse>>()
    val conferenceData = _conferenceData.toLiveData()

    private val _likeCheck = MutableLiveData<Boolean>()
    val likeCheck = _likeCheck.toLiveData()

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
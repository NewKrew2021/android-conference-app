package com.survivalcoding.ifkakao.viewmodel

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.survivalcoding.ifkakao.extension.addSources
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import com.survivalcoding.ifkakao.repository.LikeRepository
import com.survivalcoding.ifkakao.util.SingleLiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class ConferenceViewModel(
    private val confRepository: ConferenceRepository,
    private val likeRepository: LikeRepository,
) : ViewModel() {

    private val _sessions = MutableLiveData<List<Session>>()

    private val _sessionsForShow = MutableLiveData<List<Session>>()
    val sessionsForShow: LiveData<List<Session>>
        get() = _sessionsForShow

    private val likeStates = likeRepository.allLikes()

    val favoriteSessions = MediatorLiveData<List<Session>>().apply {
        addSources(_sessionsForShow, likeStates) { getFavoriteSessions() }
    }

    private val _onFilteringButtonClicked = SingleLiveEvent<Unit>()
    val onFilteringButtonClicked: LiveData<Unit>
        get() = _onFilteringButtonClicked

    var progressBarVisibility = ObservableField(View.GONE)

    private val handler = CoroutineExceptionHandler { _, throwable ->
        Log.e("Retrofit Network Error", throwable.toString())
    }

    fun requestConfData() {

        if (_sessions.value.isNullOrEmpty()) {
            viewModelScope.launch(handler) {
                progressBarVisibility.set(View.VISIBLE)
                confRepository.requestConfData().data?.let {
                    _sessions.postValue(it)
                    _sessionsForShow.postValue(it)
                }
                progressBarVisibility.set(View.GONE)
            }
        }
    }

    private fun getFavoriteSessions(): List<Session> {
        return _sessionsForShow.value?.let { list ->

            var ret = listOf<Session>()

            likeStates.value?.let { likes ->
                val favorites = likes.filter { it.liked }.map { it.idx }
                ret = list.filter { it.idx in favorites }
            }

            ret
        } ?: listOf()
    }

    fun onClickFilteringButton() {
        _onFilteringButtonClicked.postValue(Unit)
    }
}
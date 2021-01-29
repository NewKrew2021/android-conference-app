package com.example.ifkakao.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ifkakao.model.ConferenceRepository
import com.example.ifkakao.model.KakaoApiResponse
import com.example.ifkakao.model.Repository
import com.example.ifkakao.model.jsonformat.Session
import com.example.ifkakao.model.local.FavoriteSession
import kotlinx.coroutines.launch

enum class ErrorStatus {
    SERVER_ERROR, CLIENT_ERROR, UNKNOWN_ERROR, NO_ERROR
}

class SessionViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = ConferenceRepository(application)
    private val _sessionList = MutableLiveData<List<Session>>(mutableListOf())
    val sessionList: LiveData<List<Session>> get() = _sessionList
    private val _highlightSession = MutableLiveData<List<Session>>(mutableListOf())
    val highlightSession: LiveData<List<Session>> get() = _highlightSession
    private val _selectedSession = MutableLiveData<Session>()
    val selectedSession: LiveData<Session> get() = _selectedSession
    var isLoading = MutableLiveData(false)
    var errorStatus = MutableLiveData(ErrorStatus.NO_ERROR)

    private var favoriteSession: FavoriteSession? = null
    private val _isFavorite = MutableLiveData(false)
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    private var sharedSessionIndex = NOT_SESSION_INDEX
    private val _findSharedSession = MutableLiveData(false)
    val findSharedSession: LiveData<Boolean> get() = _findSharedSession

    private val _selectedFilter = MutableLiveData<MutableSet<Int>>(mutableSetOf())
    val selectedFilter: LiveData<MutableSet<Int>> get() = _selectedFilter
    private val _removedFilter = MutableLiveData<Int>()
    val removedFilter: LiveData<Int> get() = _removedFilter

    fun updateSessionData() {
        viewModelScope.launch {
            isLoading.value = true
            errorStatus.value = ErrorStatus.NO_ERROR
            when (val response = repository.getConferenceData()) {
                is KakaoApiResponse.Success -> {
                    response.result.data.let {
                        _sessionList.value = it
                        _highlightSession.value =
                            response.result.data.filter { it.spotlightYn == "Y" }
                    }
                }
                is KakaoApiResponse.Failure -> {
                    when {
                        response.errorCode in 400..499 -> errorStatus.value =
                            ErrorStatus.CLIENT_ERROR
                        response.errorCode >= 500 -> errorStatus.value = ErrorStatus.SERVER_ERROR
                        else -> errorStatus.value = ErrorStatus.UNKNOWN_ERROR
                    }
                }
            }
            isLoading.value = false
        }
    }

    fun setSharedSessionIndex(sessionIndex: Int) {
        sharedSessionIndex = sessionIndex
    }

    fun setSelectedSession(item: Session) {
        _selectedSession.value = item
        findFavoriteSessionByIndex()
    }

    fun findSharedSession() {
        _sessionList.value?.let { list ->
            val sharedSessions = list.filter { it.idx == sharedSessionIndex }
            if (sharedSessions.isNotEmpty()) {
                _selectedSession.value = sharedSessions[0]
                _findSharedSession.value = true
            }
        }
        _findSharedSession.value = false
    }

    fun addFavoriteSession() {
        _isFavorite.value = true
        viewModelScope.launch {
            _selectedSession.value?.let {
                repository.addFavoriteSession(it.idx)
                favoriteSession =
                    FavoriteSession(sessionIndex = it.idx, isFavorite = true)
            }
        }
    }

    fun deleteFavoriteSession() {
        _isFavorite.value = false
        viewModelScope.launch {
            favoriteSession?.let {
                repository.deleteFavoriteSession(it)
            }
        }
    }

    private fun findFavoriteSessionByIndex() {
        viewModelScope.launch {
            favoriteSession = repository.findFavoriteSessionByIndex(
                selectedSession.value?.idx ?: NOT_SESSION_INDEX
            )
            _isFavorite.value = favoriteSession?.isFavorite ?: false
        }
    }

    fun setFilter(filterId: Int) {
        _selectedFilter.value?.let {
            if (it.contains(filterId)) {
                it.remove(filterId)
                _removedFilter.value = filterId
                _removedFilter.value = NO_FILTER_ID
            } else {
                it.add(filterId)
                _selectedFilter.value = it.toMutableSet()
            }
        }
    }

    fun removeSharedSessionIndex() {
        sharedSessionIndex = NOT_SESSION_INDEX
    }

    fun clearFilter() {
        _selectedFilter.value?.let { filters ->
            filters.forEach { _removedFilter.value = it }
            filters.clear()
        }
        _removedFilter.value = NO_FILTER_ID
        _selectedFilter.value = mutableSetOf()
    }

    companion object {
        const val NOT_SESSION_INDEX = -1
        const val NO_FILTER_ID = 0
    }
}
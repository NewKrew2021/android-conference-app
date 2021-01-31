package com.jayden.ifkakaoclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jayden.ifkakaoclone.data.Repository
import com.jayden.ifkakaoclone.data.db.Favorite
import com.jayden.ifkakaoclone.util.SingleLiveData
import com.jayden.ifkakaoclone.view.main.model.Session
import kotlinx.coroutines.launch

class SessionViewModel(private val repository: Repository) : ViewModel() {
    data class Action(val type: Type, val url: String) {
        enum class Type {
            VIDEO_PLAY
        }
    }

    private val _sessions: MutableLiveData<List<Session>> by lazy { MutableLiveData<List<Session>>() }
    val sessions: LiveData<List<Session>> get() = _sessions

    private val _action = SingleLiveData<Action>()
    val action: LiveData<Action> get() = _action

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    val favorites: LiveData<List<Favorite>> = repository.getFavorites()

    private var _selectedFavorite = MutableLiveData<Favorite>()
    val selectedFavorite: LiveData<Favorite> get() = _selectedFavorite

    private val _selectedFilters = MutableLiveData<Set<String>>().also {
        it.value = setOf()
    }
    val selectedFilters: LiveData<Set<String>> get() = _selectedFilters

    private val _appliedFilters = MutableLiveData<Set<String>>().also {
        it.value = setOf()
    }
    val appliedFilters: LiveData<Set<String>> get() = _appliedFilters

    private val _shouldFilterWithFavorite = MutableLiveData(false)
    val shouldFilterWithFavorite: LiveData<Boolean> get() = _shouldFilterWithFavorite

    fun fetchContents() {
        viewModelScope.launch {
            _isLoading.value = true
            _sessions.value = repository.fetchContents()
            _isLoading.value = false
        }
    }

    fun setSelectedFavorite(items: List<Favorite>, sessionIndex: Int) {
        _selectedFavorite.value =
            items.find { sessionIndex == it.uid } ?: Favorite(uid = sessionIndex)
    }

    fun playVideo(url: String) {
        _action.value = Action(Action.Type.VIDEO_PLAY, url)
    }

    fun updateFavorite() {
        _selectedFavorite.value?.let { favorite ->
            viewModelScope.launch {
                favorite.isFavorite = !favorite.isFavorite
                repository.insertFavorite(favorite)
            }
        }
    }

    fun addFilter(field: String) {
        _selectedFilters.value?.let {
            _selectedFilters.value = it + field
        }
    }

    fun removeFilter(field: String) {
        _selectedFilters.value?.let {
            _selectedFilters.value = it - field
        }
    }

    fun clearFilters() {
        _selectedFilters.value?.let {
            _selectedFilters.value = setOf()
        }
    }

    fun applyFilters() {
        _appliedFilters.value?.let {
            _appliedFilters.value = _selectedFilters.value
        }
    }

    fun toggleFilterWithFavorite() {
        _shouldFilterWithFavorite.value?.let {
            _shouldFilterWithFavorite.value = !it
        }
    }
}

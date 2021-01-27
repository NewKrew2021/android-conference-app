package com.survivalcoding.ifkakao.second.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.second.model.content.ContentData
import com.survivalcoding.ifkakao.second.model.content.Repository
import com.survivalcoding.ifkakao.second.model.content.Speaker
import com.survivalcoding.ifkakao.second.model.favorite.database.Favorite
import com.survivalcoding.ifkakao.second.model.favorite.repository.FavoriteRepository
import kotlinx.coroutines.launch

class ContentViewModel(
    private val repository: Repository,
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {
    private val _data = MutableLiveData<List<ContentData>>()
    val data: LiveData<List<ContentData>> get() = _data

    private val _speakers = MutableLiveData<List<Speaker>>()
    val speakers: LiveData<List<Speaker>> get() = _speakers

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private lateinit var _selectedItem: ContentData
    val selectedItem: ContentData get() = _selectedItem

    private var _favorites = mutableListOf<Favorite>()

    private lateinit var _selectedFavorite: Favorite
    val selectedFavorite: Favorite get() = _selectedFavorite


    fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true
            _data.value = repository.getData().data
            _favorites = favoriteRepository.getAll().toMutableList()
            Log.d("aaa", _favorites.toString())
            _isLoading.value = false
        }
    }

    fun updateFavorite(item: Favorite) {
        viewModelScope.launch {
            favoriteRepository.insert(item)
        }
    }

    fun setSelectedItem(item: ContentData) {
        _selectedItem = item
        _speakers.value = item.contentsSpeackerList
        _selectedFavorite = _favorites.filter { it.idx == item.idx }.toMutableList().apply {
            if (size == 0) add(Favorite(item.idx, false))
        }[0]
    }
}
package com.survivalcoding.ifkakao.second.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.second.model.favorite.database.Favorite
import com.survivalcoding.ifkakao.second.model.favorite.repository.FavoriteRepository
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    private var _favorites = mutableListOf<Favorite>()

    private lateinit var _selectedFavorite: Favorite
    val selectedFavorite: Favorite get() = _selectedFavorite

    fun loadData(idx: Int) {
        viewModelScope.launch {
            _favorites = favoriteRepository.getAll().toMutableList()
        }
        _selectedFavorite = _favorites.filter { it.idx == idx }.toMutableList().apply {
            if (size == 0) add(Favorite(idx, false))
        }[0]
    }

    fun updateFavorite(item: Favorite) {
        viewModelScope.launch {
            favoriteRepository.insert(item)
        }
    }


}
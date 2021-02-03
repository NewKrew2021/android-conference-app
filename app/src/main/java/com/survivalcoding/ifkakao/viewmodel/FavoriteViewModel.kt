package com.survivalcoding.ifkakao.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.repository.FavoriteRepository
import com.survivalcoding.ifkakao.room.table.Favorite
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val favoriteRepository = FavoriteRepository(application.applicationContext)

    private val _getFavorite = MutableLiveData<Boolean>(false)
    val getFavorite: LiveData<Boolean> get() = _getFavorite


    val favoriteAllList: LiveData<List<Favorite>> get() = favoriteRepository.getAllFavoriteList()


    fun setFavorite(favorite: Favorite) {
        viewModelScope.launch {
            favoriteRepository.insert(favorite)
        }
        _getFavorite.value = favorite.isFavorite == 1
    }

    fun getFavoriteInfo(idx: Int) {
        viewModelScope.launch {
            if (favoriteRepository.getFavoriteWithIdx(idx) != null) {
                _getFavorite.value = favoriteRepository.getFavoriteWithIdx(idx) == 1
            }
        }
    }


}
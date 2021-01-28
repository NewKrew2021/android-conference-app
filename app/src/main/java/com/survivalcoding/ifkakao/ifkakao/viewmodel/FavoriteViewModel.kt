package com.survivalcoding.ifkakao.ifkakao.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.ifkakao.database.FavoriteTable
import com.survivalcoding.ifkakao.ifkakao.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private val _favoriteDb = FavoriteRepository(application.applicationContext)
    val favoriteDb: FavoriteRepository
        get() = _favoriteDb

    private val _favoriteList = MutableLiveData<List<FavoriteTable>>()
    val favoriteList: LiveData<List<FavoriteTable>>
        get() = _favoriteList

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    fun updateFavorite(idx: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            if (isFavorite) {
                _favoriteDb.delete(FavoriteTable(idx, 0))
                _isFavorite.value = false
            } else {
                _favoriteDb.insert(FavoriteTable(idx, 0))
                _isFavorite.value = true
            }
        }
    }

    fun getAllFavoriteList() {
        viewModelScope.launch {
            _favoriteList.value = favoriteDb.getFavoriteItem()
        }
    }

    fun isFavoriteSession(idx: Int) {
        viewModelScope.launch {
            _isFavorite.value = favoriteDb.isFavoriteSession(idx)
        }
    }
}
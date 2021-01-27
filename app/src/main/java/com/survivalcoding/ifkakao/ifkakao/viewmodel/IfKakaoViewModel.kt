package com.survivalcoding.ifkakao.ifkakao.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.survivalcoding.ifkakao.ifkakao.database.FavoriteTable
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.repository.RepositoryModel
import com.survivalcoding.ifkakao.ifkakao.repository.DefaultRepositoryModel
import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse
import com.survivalcoding.ifkakao.ifkakao.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// 이렇게 넣으면 `val model: IfKakaoViewModel by activityViewModels()` 여기서 application을 넘겨줘야하지 않나?
class IfKakaoViewModel(application: Application) : AndroidViewModel(application) {
    private val _ifKakaoSessionList = MutableLiveData<IfKakaoResponse>()
    val ifKakaoSessionList: LiveData<IfKakaoResponse>  // liveData getter
        get() = _ifKakaoSessionList

    private val _presentationData = MutableLiveData<Data>()
    val presentationData: LiveData<Data>
        get() = _presentationData

    private val _favoriteDb = FavoriteRepository(application.applicationContext)
    val favoriteDb: FavoriteRepository
        get() = _favoriteDb

    private lateinit var _favoriteList: List<FavoriteTable>
    val favoriteList: List<FavoriteTable>
        get() = _favoriteList

    private val ifKakaoRepositoryModel: DefaultRepositoryModel = RepositoryModel()

    fun loadIfKakaoItem() {
        viewModelScope.launch {
            _ifKakaoSessionList.value = ifKakaoRepositoryModel.getParsedIfKakaoResponse()
        }
    }

    fun getAllFavoriteList() {
        viewModelScope.launch(Dispatchers.IO) {
            _favoriteList = favoriteDb.getFavoriteItem()
        }
    }

    fun updateFavorite(isFavorite: Boolean, idx: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            if (isFavorite) {
                favoriteDb.delete(FavoriteTable(idx, 0))    // 바로 만들지 말고, 객체를 넘겨주던가 해야되는데..
            } else {
                favoriteDb.insert(FavoriteTable(idx, 0))
            }
        }
    }

    fun isFavoriteSession(idx: Int): Boolean {
        return favoriteList.contains(FavoriteTable(idx, 0))
    }

    fun setPresentationData(item: Data) {
        _presentationData.value = item
    }
}
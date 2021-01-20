package com.survivalcoding.ifkakao.ifkakao.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.ifkakao.data.DataModel
import com.survivalcoding.ifkakao.ifkakao.data.DefaultDataModel
import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoItem
import kotlin.reflect.KProperty

class IfKakaoViewModel : ViewModel() {
    private val _ifKakaoItem: MutableLiveData<IfKakaoItem> by lazy {
        MutableLiveData<IfKakaoItem>().also {
            loadIfKakaoItem()
        }
    }
    val ifkakaoItem: LiveData<IfKakaoItem>
        get() = _ifKakaoItem

    private val ifKakaoModel: DefaultDataModel = DataModel()

    private fun loadIfKakaoItem() {
        val parsedData = ifKakaoModel.getIfKakaoItem(ifKakaoModel.getRequest())
//        _ifKakaoItem.postValue(parsedData)
    }
}
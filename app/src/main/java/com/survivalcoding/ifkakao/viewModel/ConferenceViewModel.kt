package com.survivalcoding.ifkakao.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.DetailRecyclerType
import com.survivalcoding.ifkakao.repository.ConferenceRepository

class ConferenceViewModel : ViewModel() {

    private val _listData = MutableLiveData<List<ConferenceAppFront>>()
    val listData get() = _listData

    //var currentPosition = 0
    private var _singleData = MutableLiveData<ConferenceAppFront>()
    val singleData get() = _singleData
    private var _selectInterests = mutableSetOf<String>()
    val selectInterests get() = _selectInterests

    fun getData() {
        ConferenceRepository.getData({
            _listData.postValue(it)
        })
    }

    fun getHighlightData(): MutableList<ConferenceAppFront> {
        var tmpList = mutableListOf<ConferenceAppFront>()

        _listData.value?.let {

            for (i in 0..it.size - 1) {
                if (it.get(i).spotlightYn == "Y") tmpList.add(it.get(i))
            }
        }
        return tmpList
    }

    fun getRelativeData(data: String): MutableList<DetailRecyclerType> {
        var tmpList = mutableListOf<DetailRecyclerType>()
        _listData.value?.let {
            for (i in 0..it.size - 1) {
                if (it.get(i).field == data) {
                    if (it.get(i).hashCode() == data.hashCode()) continue
                    tmpList.add(
                        it.get(i)
                    )
                }
            }
        }

        return tmpList
    }
}
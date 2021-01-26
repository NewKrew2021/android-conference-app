package com.survivalcoding.ifkakao.repository

object FavoritesRepository {   //나중에 Db로 교체

    private var _dataList = mutableSetOf<Int>()
    val datalist get() = _dataList

    fun isExist(id: Int) = _dataList.contains(id)

    fun addFavoritesItem(id: Int) {
        _dataList.add(id)
    }

    fun removeFavoritesItem(id: Int) {
        _dataList.remove(id)
    }

}
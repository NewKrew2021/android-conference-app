package com.survivalcoding.ifkakao.repository

import androidx.lifecycle.LiveData
import com.survivalcoding.ifkakao.model.like.Like
import com.survivalcoding.ifkakao.model.like.LikeDao

class LikeRepository(private val likeDao: LikeDao) {

    val allLikes: LiveData<List<Like>> = likeDao.getAllLikeStates()

    suspend fun updateState(like: Like) {
        likeDao.insert(like)
    }

    fun likeByIdx(idx: Int): LiveData<Boolean> = likeDao.getLikeStateByIdx(idx)
}
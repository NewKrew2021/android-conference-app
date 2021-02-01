package com.survivalcoding.ifkakao.model.like

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LikeDao {

    @Query("SELECT liked FROM like_table WHERE idx = :idx")
    fun getLikeStateByIdx(idx: Int): LiveData<Boolean>

    @Query("SELECT * FROM like_table")
    suspend fun getAllLikeStates(): List<Like>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(like: Like)

}
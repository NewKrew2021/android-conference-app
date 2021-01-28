package com.survivalcoding.ifkakao.data.local.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.survivalcoding.ifkakao.data.model.entity.Favorite

interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteSession(favorite: Favorite)

    @Query("DELETE FROM favorite WHERE sessionId = :id")
    suspend fun deleteFavoriteSessionById(id: Int)

    @Query("SELECT * FROM favorite")
    suspend fun getAllFavoriteSessionId() : List<Int>
}
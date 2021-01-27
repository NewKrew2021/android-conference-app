package com.example.ifkakao.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SessionDao {
    @Query("SELECT * FROM FavoriteSession")
    fun getAllFavoriteSessions(): LiveData<List<FavoriteSession>>

    @Query("SELECT * FROM FavoriteSession WHERE session_index = :sessionIndex")
    fun findBySessionIndex(sessionIndex: Int): FavoriteSession

    @Insert
    fun addFavoriteSession(favoriteSession: FavoriteSession)

    @Delete
    fun delete(favoriteSession: FavoriteSession)
}
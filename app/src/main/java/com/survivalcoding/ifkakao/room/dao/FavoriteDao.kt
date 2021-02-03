package com.survivalcoding.ifkakao.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.survivalcoding.ifkakao.room.table.Favorite

@Dao
interface FavoriteDao {
    @Query("SELECT * from favorite where isFavorite == 1")
    fun getAll(): LiveData<List<Favorite>>

    @Query("SELECT isFavorite from favorite WHERE id == :id")
    suspend fun getFavoriteWithColumn(id: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: Favorite)

}
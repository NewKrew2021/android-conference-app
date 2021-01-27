package com.jayden.ifkakaoclone.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// DAO must be an interface of abstract class.
@Dao
interface FavoriteDao {
    @Query("SELECT * FROM favorites")
    fun getFavorites(): LiveData<List<Favorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: Favorite)
}
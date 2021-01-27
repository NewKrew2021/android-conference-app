package com.survivalcoding.ifkakao.db

import androidx.room.*

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM favorites")
    suspend fun getAll(): List<Int>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorites: Favorites)

    @Delete
    suspend fun delete(favorites: Favorites)

}
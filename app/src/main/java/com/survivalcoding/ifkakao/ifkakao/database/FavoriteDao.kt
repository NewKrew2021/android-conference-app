package com.survivalcoding.ifkakao.ifkakao.database

import androidx.room.*

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM FavoriteTable")
    suspend fun getAll(): List<FavoriteTable>

    @Query("SELECT * FROM FavoriteTable Where idx = (:idx)")
    suspend fun isFavoriteSession(idx: Int): FavoriteTable?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIdx(idx: FavoriteTable)

    @Delete
    suspend fun deleteIdx(idx: FavoriteTable)

}
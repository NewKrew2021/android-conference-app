package com.survivalcoding.ifkakao.ifkakao.database

import androidx.room.*

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM FavoriteTable")
    fun getAll(): List<FavoriteTable>

    @Query("SELECT * FROM FavoriteTable Where idx = (:idx)")
    fun isFavoriteSession(idx: Int): FavoriteTable?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIdx(idx: FavoriteTable)

    @Delete
    fun deleteIdx(idx: FavoriteTable)

}
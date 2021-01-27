package com.example.ifkakao.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteSession(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "session_index") val sessionIndex: Int,
    @ColumnInfo(name = "favorite") var isFavorite: Boolean
)

package com.survivalcoding.ifkakao.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class Favorite(
    @PrimaryKey
    var sessionId: Int,
    var isFavorite: Int,
)
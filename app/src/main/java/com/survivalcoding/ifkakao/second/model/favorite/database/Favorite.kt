package com.survivalcoding.ifkakao.second.model.favorite.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey val idx: Int,
    var isFavorite: Boolean
)
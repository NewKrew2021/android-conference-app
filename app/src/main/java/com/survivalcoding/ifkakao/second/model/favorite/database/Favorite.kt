package com.survivalcoding.ifkakao.second.model.favorite.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    var isFavorite: Boolean
)
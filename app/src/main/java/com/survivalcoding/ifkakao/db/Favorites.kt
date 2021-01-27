package com.survivalcoding.ifkakao.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorites(
    @PrimaryKey var favoritesId: Int,
)
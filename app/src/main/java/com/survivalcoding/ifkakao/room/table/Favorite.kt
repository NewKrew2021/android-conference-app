package com.survivalcoding.ifkakao.room.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite (
    @PrimaryKey val id : Int,
    var isFavorite : Int
)


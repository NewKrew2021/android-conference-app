package com.jayden.ifkakaoclone.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class Favorite(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    var isFavorite: Boolean = false
)

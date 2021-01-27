package com.survivalcoding.ifkakao.model.like

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "like_table")
data class Like(
    @PrimaryKey
    var idx: Int,
    var liked: Boolean,
)
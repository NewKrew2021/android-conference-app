package com.survivalcoding.ifkakao.ifkakao.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteTable(
    @PrimaryKey(autoGenerate = true) val idx: Int,
    val count: Int, // @ColumnInfo : 변수명과 테이블명을 달리하고 싶을 때 사용
)
package com.survivalcoding.ifkakao.second.model.filter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Filter(
    var data: Map<FilterType, String>
) : Parcelable
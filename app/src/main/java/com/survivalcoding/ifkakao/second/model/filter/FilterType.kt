package com.survivalcoding.ifkakao.second.model.filter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class FilterType : Parcelable {
    FIELD, SERVICE_BUSINNES, TECH
}
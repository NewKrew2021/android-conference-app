package com.survivalcoding.ifkakao.second.util

import com.survivalcoding.ifkakao.second.model.filter.FilterType

fun Map<FilterType, String>.find(filterType: FilterType, name: String): Boolean =
    this[filterType]?.let { it == name } ?: false

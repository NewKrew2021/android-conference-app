package com.jayden.ifkakaoclone.view.main.model

data class Filter(
    val type: FilterType,
    val name: String
)

enum class FilterType {
    FIELD, KEYWORD_SERVICE_BUSINESS, KEYWORD_TECH
}
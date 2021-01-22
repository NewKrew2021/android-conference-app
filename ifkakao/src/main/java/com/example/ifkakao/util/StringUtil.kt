package com.example.ifkakao.util

import androidx.core.text.HtmlCompat

fun String.fromHtml(): String =
    HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
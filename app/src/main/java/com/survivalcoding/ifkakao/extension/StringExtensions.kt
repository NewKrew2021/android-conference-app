package com.survivalcoding.ifkakao.extension

import androidx.core.text.HtmlCompat

fun getStringExceptTags(origin: String) = HtmlCompat.fromHtml(
    origin, HtmlCompat.FROM_HTML_MODE_LEGACY
).toString()
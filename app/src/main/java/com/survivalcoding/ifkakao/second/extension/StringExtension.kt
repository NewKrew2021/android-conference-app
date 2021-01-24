package com.survivalcoding.ifkakao.second.extension

import androidx.core.text.HtmlCompat

fun String.removeTag() = HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
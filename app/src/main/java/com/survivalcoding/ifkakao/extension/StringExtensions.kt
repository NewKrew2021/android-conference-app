package com.survivalcoding.ifkakao.extension

import androidx.core.text.HtmlCompat

fun String.transformTagsToNewline() = HtmlCompat.fromHtml(
    this, HtmlCompat.FROM_HTML_MODE_LEGACY
).toString()
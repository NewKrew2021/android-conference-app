package com.jayden.ifkakaoclone.extensions

import androidx.core.text.HtmlCompat

fun String.removeHtmlTag(): String =
    HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
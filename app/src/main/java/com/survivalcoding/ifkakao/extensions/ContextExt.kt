package com.survivalcoding.ifkakao.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.playMedia(file: Uri) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = file
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    }
}
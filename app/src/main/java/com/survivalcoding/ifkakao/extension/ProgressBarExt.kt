package com.survivalcoding.ifkakao.extension

import android.view.View
import android.widget.ProgressBar


fun ProgressBar.start() {
    this.visibility = View.VISIBLE
}

fun ProgressBar.stop() {
    this.visibility = View.GONE
}
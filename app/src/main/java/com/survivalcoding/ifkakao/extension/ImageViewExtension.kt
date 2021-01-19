package com.survivalcoding.ifkakao.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(imageUrl: String) {
    Glide.with(this).load(imageUrl).centerCrop().into(this)
}
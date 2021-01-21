package com.survivalcoding.ifkakao.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadUrlWithRoundCorner(imageUrl: String) {
    Glide.with(this).load(imageUrl).transform(CenterCrop(), RoundedCorners(20)).into(this)
}
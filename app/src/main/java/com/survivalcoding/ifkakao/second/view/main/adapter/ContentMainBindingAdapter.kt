package com.survivalcoding.ifkakao.second.view.main.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.api.load
import com.survivalcoding.ifkakao.R

@BindingAdapter("url")
fun loadImage(view: ImageView, url: String) {
    val context = view.context
    val imageLoader = ImageLoader(context) {
        crossfade(true)
        placeholder(R.drawable.thumbnail_placeholder)
        error(R.drawable.thumbnail_placeholder)
        availableMemoryPercentage(0.1)
        bitmapPoolPercentage(0.1)
    }
    view.load(url, imageLoader)
}
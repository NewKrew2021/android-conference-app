package com.survivalcoding.ifkakao.ui.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun loadImageFromUrl(
    view: ImageView,
    url: String,
) {
    view.load(url)
}
package com.survivalcoding.ifkakao.bindingAdapters

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import com.bumptech.glide.Glide

@BindingAdapter("highlightImage")
fun sethightligthImageView(view: ImageView, image: Drawable) {
    view.load(image)
    view.imageAlpha = 130
}

@BindingAdapter("handImage")
fun setHandImageVIew(view: ImageView, image: Drawable) {
    Glide.with(view).load(image).into(view)
}


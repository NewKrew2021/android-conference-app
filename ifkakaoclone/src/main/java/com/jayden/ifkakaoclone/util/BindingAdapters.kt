package com.jayden.ifkakaoclone.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("imageUrl", "placeholderDrawable", "roundCornerRadius")
fun loadImageFromUrlWithPlaceHolder(imageView: ImageView, imageUrl: String, placeholderDrawable: Drawable, roundCornerRadius: Float) {
    imageView.load(imageUrl) {
        crossfade(true)
        placeholder(placeholderDrawable)
        transformations(RoundedCornersTransformation(roundCornerRadius))
    }
}


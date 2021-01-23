package com.jayden.ifkakaoclone.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.VideoView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import coil.transform.Transformation

@BindingAdapter(
    value = ["imageUrl", "placeholderDrawable", "roundCornerRadius", "isCircleCrop"],
    requireAll = false
)
fun ImageView.loadImageFromUrlWithPlaceHolder(
    imageUrl: String,
    placeholderDrawable: Drawable,
    roundCornerRadius: Float,
    isCircleCrop: Boolean
) {
    val transformationBuilder = mutableListOf<Transformation>().apply {
        if (roundCornerRadius >= 0f) add(RoundedCornersTransformation(roundCornerRadius))
        if (isCircleCrop) add(CircleCropTransformation())
    }

    load(imageUrl) {
        crossfade(true)
        placeholder(placeholderDrawable)
        transformations(transformationBuilder)
    }
}

@BindingAdapter("videoUrlWithLoop")
fun VideoView.loadVideoThenLoop(videoUrl: String) {
    setVideoPath(videoUrl)

    setOnPreparedListener {
        it.isLooping = true
        it.start()
    }
}

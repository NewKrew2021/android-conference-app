package com.jayden.ifkakaoclone.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.VideoView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter(
    value = ["imageUrl", "placeholderDrawable", "roundCornerRadius"],
    requireAll = false
)
fun ImageView.loadImageFromUrlWithPlaceHolder(
    imageUrl: String,
    placeholderDrawable: Drawable,
    roundCornerRadius: Float,
) {
    load(imageUrl) {
        crossfade(true)
        placeholder(placeholderDrawable)
        if (roundCornerRadius >= 0f) transformations(RoundedCornersTransformation(roundCornerRadius))
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

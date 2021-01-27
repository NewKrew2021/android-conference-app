package com.survivalcoding.ifkakao.ui.databinding

import android.widget.ImageView
import android.widget.VideoView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("imageUrl")
fun loadImageFromUrl(
    view: ImageView,
    url: String,
) {
    view.load(url) {
        transformations(RoundedCornersTransformation(16.0F))
    }
}

@BindingAdapter("speakerImageUrl")
fun loadSpeakerImageFromUrl(
    view: ImageView,
    url: String,
) {
    view.load(url) {
        transformations(RoundedCornersTransformation(88.0F))
    }
}

@BindingAdapter("videoImageUrl")
fun loadVideoImageFromUrl(
    view: ImageView,
    url: String,
) {
    view.load(url)
}

@BindingAdapter("videoUrl")
fun loadVideoFromUrl(
    view: VideoView,
    url: String,
) {
    view.apply {
        setVideoPath(url)
        setOnPreparedListener {
            it.isLooping = true
            it.start()
        }
    }
}
package com.survivalcoding.ifkakao.ui.databinding

import android.widget.ImageView
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
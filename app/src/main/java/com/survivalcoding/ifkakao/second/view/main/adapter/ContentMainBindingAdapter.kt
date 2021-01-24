package com.survivalcoding.ifkakao.second.view.main.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import coil.transform.Transformation
import com.survivalcoding.ifkakao.R

@BindingAdapter("url", "round")
fun loadImage(view: ImageView, url: String, round: Float) {
    val transformationBuilder = mutableListOf<Transformation>().apply {
        add(RoundedCornersTransformation(round))
    }
    view.load(url) {
        crossfade(true)
        placeholder(R.drawable.thumbnail_placeholder)
        transformations(transformationBuilder)
    }
}
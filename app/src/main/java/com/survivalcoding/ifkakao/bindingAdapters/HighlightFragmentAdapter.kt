package com.survivalcoding.ifkakao.bindingAdapters

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.Glide

@BindingAdapter("highlightImage")
fun sethightligthImageView(view: ImageView, image: Drawable) {
    view.load(image)
    view.setImageAlpha(130)
}

@BindingAdapter("handImage")
fun setHandImageVIew(view: ImageView, image: Drawable) {
    Glide.with(view).load(image).into(view)
}

@BindingAdapter("totalImageView")
fun setTotalImageView(view: ImageView, image: Drawable) {
    view.load(image) {
        transformations(
            RoundedCornersTransformation(
                topRight = 20f,
                topLeft = 20f,
                bottomLeft = 20f,
                bottomRight = 20f
            )
        )
    }
}
package com.survivalcoding.ifkakao.ui.imagebind

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("bindImage")
fun bindImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
        .load(imageUrl)
        .fitCenter()
        .into(view)
}

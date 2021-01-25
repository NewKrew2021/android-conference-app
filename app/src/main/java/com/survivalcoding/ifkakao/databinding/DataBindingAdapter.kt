package com.survivalcoding.ifkakao.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.survivalcoding.ifkakao.extension.loadUrl
import com.survivalcoding.ifkakao.extension.loadUrlWithRoundCorner


@BindingAdapter("imageUrlWithRound")
fun loadImageWithRound(view: ImageView, url: String) {
    view.loadUrlWithRoundCorner(url)
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    view.loadUrl(url)
}
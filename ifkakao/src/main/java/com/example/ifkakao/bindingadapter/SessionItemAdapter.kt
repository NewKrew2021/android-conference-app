package com.example.ifkakao.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.ifkakao.R


@BindingAdapter("sessionTitle")
fun setSessionTitle(textView: TextView, sessionTitle: String) {
    textView.text = HtmlCompat.fromHtml(sessionTitle, HtmlCompat.FROM_HTML_MODE_LEGACY)
}

@BindingAdapter("thumbnailImageUrl")
fun setImageFromUrl(imageView: ImageView, url: String) {
    // CrossFade 전환 효과를 위한 factory
    val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

    Glide.with(imageView)
        .load(url)
        .transition(withCrossFade(factory))
        .centerInside()
        .placeholder(R.drawable.temp_thumbnail)
        .into(imageView)
}
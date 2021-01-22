package com.example.ifkakao.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.ifkakao.R

@BindingAdapter("sessionTitle")
fun TextView.setSessionTitle(sessionTitle: String) {
    this.text = HtmlCompat.fromHtml(sessionTitle, HtmlCompat.FROM_HTML_MODE_LEGACY)
}

@BindingAdapter("thumbnailImageUrl", "cornerRadius", requireAll = false)
fun ImageView.setImageFromUrl(url: String, roundingRadius: Int = 0) {
    // CrossFade 전환 효과를 위한 factory
    val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()

    Glide.with(this)
        .load(url)
        .transition(withCrossFade(factory)).apply {
            // 모서리 부분 둥글게 처리
            if (roundingRadius > 0) this.apply(
                RequestOptions().transform(
                    CenterInside(),
                    RoundedCorners(roundingRadius)
                )
            ) else this.centerInside()
        }
        .placeholder(R.drawable.temp_thumbnail)
        .into(this)
}
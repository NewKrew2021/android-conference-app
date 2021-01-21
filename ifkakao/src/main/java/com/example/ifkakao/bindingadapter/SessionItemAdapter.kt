package com.example.ifkakao.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.ifkakao.R

@BindingAdapter("sessionTitle")
fun setSessionTitle(textView: TextView, sessionTitle: String) {
    textView.text = HtmlCompat.fromHtml(sessionTitle, HtmlCompat.FROM_HTML_MODE_LEGACY)
}

@BindingAdapter("thumbnailImageUrl")
fun setImageFromUrl(imageView: ImageView, url: String) {
    imageView.load(url) {
        crossfade(true)
        placeholder(R.drawable.temp_thumbnail)
        transformations(listOf(RoundedCornersTransformation(5f)))
    }
}
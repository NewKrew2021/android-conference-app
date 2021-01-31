package com.survivalcoding.ifkakao.ifkakao.view.databinding

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.survivalcoding.ifkakao.R

// item_if_kakao.xml의 `app:imageUrl="@{...}"`와 binding된다. > adapter역할이다.
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    val option = RequestOptions().transform(RoundedCorners(30))
    Glide.with(view.rootView.context)
        .load(url)
        .apply(option)
        .into(view)
}

@BindingAdapter("titleText")
fun removeHtml(view: TextView, text: String) {
    val str = text.replace("<br>", "\n")
    view.text = str
}

@BindingAdapter("presenterImageUrl")
fun loadPresenterImage(view: ImageView, url: String) {
    Glide.with(view.rootView.context)
        .load(url)
        .circleCrop()
        .into(view)
}

@BindingAdapter("nameKo", "nameEn")
fun concatName(view: TextView, nameKo: String, nameEn: String) {
    view.text = "${nameKo} ${nameEn}"
}

@BindingAdapter("webViewPlay")
fun webViewPlay(view: WebView, uri: String) {
    view.settings.javaScriptEnabled = true
    view.webChromeClient = WebChromeClient()
    view.loadUrl(uri)
}

@BindingAdapter("favoriteImage")
fun favorite(view: ImageButton, isFavorite: Boolean) {
    val imageId =
        if (isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24

    view.setImageResource(imageId)
}
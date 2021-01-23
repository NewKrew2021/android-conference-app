package com.survivalcoding.ifkakao.ifkakao.view.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

// item_if_kakao.xml의 `app:imageUrl="@{...}"`와 binding된다. > adapter역할이다.
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    val option = RequestOptions().transform(RoundedCorners(30))
    Glide.with(view.rootView.context)
        .load(url)
        .apply(option)
        .into(view)
}
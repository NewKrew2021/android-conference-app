package com.survivalcoding.ifkakao.view.main.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("videoUrl")
fun setVideoThumbnail(imageView: ImageView, url: String) {
    Glide.with(imageView)
        .load("https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604391757468")
        .into(imageView)
}

@BindingAdapter("title")
fun replaceBr(textView: TextView, text: String) {
    textView.text = text.replace("<br>", "\n")
}
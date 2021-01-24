package com.survivalcoding.ifkakao.databinding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.survivalcoding.ifkakao.extension.loadUrlWithRoundCorner

@BindingAdapter("title")
fun setTitle(view: TextView, title: String) {
    view.text = title.replace("<br>", "\n")
}

@BindingAdapter("field")
fun setField(view: TextView, field: String) {
    view.text = field
}

@BindingAdapter("runningTime")
fun setRunningTime(view: TextView, runningTime: String) {
    view.text = runningTime
}

@BindingAdapter("imageUrlWithRound")
fun loadImage(view: ImageView, url: String) {
    view.loadUrlWithRoundCorner(url)
}
package com.survivalcoding.ifkakao.view

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("videoUrl")
fun setVideoThumbnail(imageView: ImageView, url: String) {
    val dummyThumbnailList = listOf(
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604391757468",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604390979629",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604390257442",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604390637307",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604391337670",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604390383217",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604390480970",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604390818639",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604391192949",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604391914508",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Ffile%2Ffile-1604391083727",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Fimages%2Fmo%2Fthumb_service.png",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Fimages%2Fmo%2Fthumb_tech.png",
        "https://t1.kakaocdn.net/thumb/C236x132/?fname=https%3A%2F%2Ft1.kakaocdn.net%2Fservice_if_kakao_prod%2Fimages%2Fmo%2Fthumb_business.png",
    )

    Glide.with(imageView)
        .load(dummyThumbnailList.random())
        .into(imageView)
}

@BindingAdapter("title")
fun replaceBr(textView: TextView, text: String) {
    textView.text = text.replace("<br>", "\n")
}

@BindingAdapter("imgUrl")
fun setImage(imageView: ImageView, url: String) {
    Glide.with(imageView)
        .load(url)
        .into(imageView)
}
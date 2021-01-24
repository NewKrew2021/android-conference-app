package com.example.ifkakao.bindingadapter

import android.view.LayoutInflater
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.example.ifkakao.databinding.SessionSpeakerLayoutBinding
import com.example.ifkakao.model.jsonformat.Session
import com.example.ifkakao.util.fromHtml

@BindingAdapter("sessionTitle")
fun TextView.setSessionTitle(sessionTitle: String) {
    this.text = sessionTitle.fromHtml()
}

@BindingAdapter("imageUrl", "placeHolder", "cornerRadius", requireAll = false)
fun ImageView.setImageFromUrl(url: String, placeHolderId: Int, roundingRadius: Int = 0) {
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
        .placeholder(placeHolderId)
        .into(this)

}

@BindingAdapter("speakerList")
fun LinearLayout.showAllSpeaker(session: Session) {
    session.contentsSpeakerList.zip(session.linkList.speakerProfile).map {
        val speakerView =
            SessionSpeakerLayoutBinding.inflate(LayoutInflater.from(context), this, false).apply {
                val speakerName = "${it.first.nameKo} ${it.first.nameEn}"
                imageUrl = it.second.url
                name = speakerName
                company = it.first.company
                occupation = it.first.occupation
            }
        speakerView
    }.forEach { this.addView(it.root) }
}

@BindingAdapter("videoUrl")
fun WebView.loadVideoFromUrl(url: String) {
    settings.javaScriptEnabled = true
    webViewClient = WebViewClient()
    loadUrl(url)
}
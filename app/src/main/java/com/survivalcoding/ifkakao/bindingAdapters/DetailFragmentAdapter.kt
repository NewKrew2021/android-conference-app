package com.survivalcoding.ifkakao.bindingAdapters

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter

@BindingAdapter("url")
fun setWebView(view: WebView, url: String) {
    view.settings.javaScriptEnabled = true
    view.webViewClient = WebViewClient()
    view.loadUrl(url)
}
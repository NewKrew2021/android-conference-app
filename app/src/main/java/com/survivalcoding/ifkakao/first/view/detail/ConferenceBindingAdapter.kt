package com.survivalcoding.ifkakao.first.view.detail

import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.survivalcoding.ifkakao.R

@BindingAdapter("link")
fun loadLinkText(view: TextView, link: String) {
    val context = view.context
    val linkText = SpannableString(context.getString(R.string.hyperlink_text)).apply {
        setSpan(
            URLSpan(link),
            0,
            context.getString(R.string.hyperlink_text).length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    view.movementMethod = LinkMovementMethod.getInstance()
    view.text = linkText
}
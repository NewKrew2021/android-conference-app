package com.example.ifkakao.bindingadapter

import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ifkakao.adapter.SessionAdapter
import com.example.ifkakao.model.jsonformat.Session

@BindingAdapter("sessionList")
fun RecyclerView.setSessionList(sessionList: List<Session>) {
    val adapter = (this.adapter as SessionAdapter)
    adapter.submitList(sessionList)
}

@BindingAdapter("layout_width")
fun View.setLayoutWidth(dimen: Float) {
    updateLayoutParams<ViewGroup.MarginLayoutParams> {
        width = dimen.toInt()
    }
}
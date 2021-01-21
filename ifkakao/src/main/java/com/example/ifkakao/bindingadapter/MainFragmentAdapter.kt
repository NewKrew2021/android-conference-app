package com.example.ifkakao.bindingadapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ifkakao.adapter.SessionAdapter
import com.example.ifkakao.model.jsonformat.Session

@BindingAdapter("sessionList")
fun setSessionList(recyclerView: RecyclerView, sessionList: List<Session>) {
    val adapter = (recyclerView.adapter as SessionAdapter)
    adapter.submitList(sessionList)
}
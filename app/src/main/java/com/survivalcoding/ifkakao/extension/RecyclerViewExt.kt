package com.survivalcoding.ifkakao.extension

import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val LinearVerticalLayout = { context: Context ->
    LinearLayoutManager(
        context,
        LinearLayoutManager.VERTICAL,
        false
    )
}

val LinearHorizontalLayout = { context: Context ->
    LinearLayoutManager(
        context,
        LinearLayoutManager.HORIZONTAL,
        false
    )
}

fun RecyclerView.initToLinearLayout(
    layoutType: Int,
    isDivider: Boolean,
    adapter: RecyclerView.Adapter<*>
) {
    apply {
        setHasFixedSize(true)
        layoutManager = if (layoutType == LinearLayoutManager.VERTICAL) {
            LinearVerticalLayout(context)
        } else {
            LinearHorizontalLayout(context)
        }
        if(isDivider) {
            addItemDecoration(DividerItemDecoration(context, layoutType))
        }

        this.adapter = adapter
    }
}
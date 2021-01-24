package com.survivalcoding.ifkakao.extension

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

val LinearVerticalLayout = { context: Context ->
    LinearLayoutManager(
        context,
        LinearLayoutManager.VERTICAL,
        false
    )
}
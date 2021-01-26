package com.survivalcoding.ifkakao.extension

import android.graphics.Color
import android.widget.ToggleButton
import com.survivalcoding.ifkakao.R

fun ToggleButton.on() {
    this.setBackgroundResource(R.drawable.button_on_stroke_white_2dp)
    this.setTextColor(Color.parseColor("#FF000000"))
    this.isChecked = true
}

fun ToggleButton.off() {
    this.setBackgroundResource(R.drawable.button_stroke_white_2dp)
    this.setTextColor(Color.parseColor("#FFFFFFFF"))
    this.isChecked = false
}
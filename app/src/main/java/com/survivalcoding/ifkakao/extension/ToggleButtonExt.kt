package com.survivalcoding.ifkakao.extension

import android.graphics.Color
import android.widget.ToggleButton
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.util.COLOR_BLACK
import com.survivalcoding.ifkakao.util.COLOR_WHITE

fun ToggleButton.on() {
    this.setBackgroundResource(R.drawable.button_on_stroke_white_2dp)
    this.setTextColor(Color.parseColor(COLOR_WHITE))
    this.isChecked = true
}

fun ToggleButton.off() {
    this.setBackgroundResource(R.drawable.button_stroke_white_2dp)
    this.setTextColor(Color.parseColor(COLOR_BLACK))
    this.isChecked = false
}

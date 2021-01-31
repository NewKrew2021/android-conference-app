package com.survivalcoding.ifkakao.bindingAdapters

import android.net.Uri
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.VideoView
import androidx.databinding.BindingAdapter
import com.survivalcoding.ifkakao.MySpinnerListener
import com.survivalcoding.ifkakao.R

@BindingAdapter("setUri")
fun setVideoView(view: VideoView, tmp: String?) {

    view.apply {
        setVideoURI(Uri.parse("android.resource://com.survivalcoding.ifkakao/raw/main_video"))
        setOnPreparedListener {
            it.start()
        }
        setOnCompletionListener {
            it.start()
        }
    }
}

@BindingAdapter("setSpinner")
fun setSpinner(view: Spinner, tmp: String?) {
    val dataArr = arrayOf("Day1", "Day2", "Day3(All)")
    val spinnerAdapter = ArrayAdapter(view.context, R.layout.spinner_item, dataArr)

    view.apply {
        adapter = spinnerAdapter
        onItemSelectedListener = MySpinnerListener()
        setSelection(2)
    }
}

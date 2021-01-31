package com.survivalcoding.ifkakao.extension

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.survivalcoding.ifkakao.R

fun Fragment.setToolbar(toolbar: Toolbar, textView: TextView) {
    val activity = activity as AppCompatActivity
    activity.setSupportActionBar(toolbar)
    setHasOptionsMenu(true)

    textView.setOnClickListener {
        findNavController().navigate(R.id.fragment_main)
    }
}
package com.survivalcoding.ifkakao.extension

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.ui.view.home.MainFragment

fun Fragment.setToolbar(toolbar: Toolbar, textView: TextView) {
    val activity = activity as AppCompatActivity
    activity.setSupportActionBar(toolbar)
    setHasOptionsMenu(true)

    textView.setOnClickListener {
        replaceFragment<MainFragment>(R.id.fragment_container_view)
    }
}
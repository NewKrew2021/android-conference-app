package com.survivalcoding.ifkakao.extension

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment

fun Fragment.startActivityForXml(filter: String, uri: Uri) {
    startActivity(Intent(filter, uri))
}
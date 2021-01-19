package com.example.ifkakao.util

import android.content.Context
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

fun readTextFile(context: Context, resId: Int): String {
    var result = ""
    val txtResource: InputStream = context.resources.openRawResource(resId)
    val byteArrayOutputStream = ByteArrayOutputStream()
    var i: Int
    try {
        i = txtResource.read()
        while (i != -1) {
            byteArrayOutputStream.write(i)
            i = txtResource.read()
        }
        result = String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8)
        txtResource.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return result.trim { it <= ' ' }
}
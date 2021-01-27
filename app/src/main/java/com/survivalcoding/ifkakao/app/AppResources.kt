package com.survivalcoding.ifkakao.app

import android.content.Context

object AppResources {

    @JvmStatic
    fun getContext(): Context{
        return App.instance.context()
    }
}
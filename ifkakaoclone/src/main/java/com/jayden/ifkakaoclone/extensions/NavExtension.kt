package com.jayden.ifkakaoclone.extensions

import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions

fun NavController.navigateSingleTop(@IdRes resId: Int) {
    val navOptions = NavOptions.Builder().apply {
        setLaunchSingleTop(true)
    }.build()

    navigate(resId, null, navOptions)
}
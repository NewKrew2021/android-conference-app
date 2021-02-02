package com.survivalcoding.ifkakao.extension

import androidx.fragment.app.FragmentManager

fun FragmentManager.clearBackStack(){
    popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}
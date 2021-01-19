package com.survivalcoding.ifkakao.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

inline fun <reified F : Fragment> AppCompatActivity.replaceFragment(containerViewId: Int) {
    supportFragmentManager.commit {
        setReorderingAllowed(true)
        replace<F>(containerViewId)
    }
}

inline fun <reified F : Fragment> Fragment.replaceFragment(containerViewId: Int) {
    parentFragmentManager.commit {
        setReorderingAllowed(true)
        addToBackStack(null)
        replace<F>(containerViewId)
    }
}
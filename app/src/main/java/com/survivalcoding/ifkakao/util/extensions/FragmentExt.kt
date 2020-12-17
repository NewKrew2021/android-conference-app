package com.survivalcoding.ifkakao.util.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

inline fun <reified T : Fragment> Fragment.navigateTo(containerId: Int) {
    parentFragmentManager.commit {
        setReorderingAllowed(true)
        replace<T>(containerId)
        addToBackStack(null)
    }
}
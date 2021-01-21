package com.example.ifkakao.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

inline fun <reified F : Fragment> Fragment.replaceTransaction(containerViewId: Int) {
    parentFragmentManager.commit {
        setReorderingAllowed(true)
        addToBackStack(null)
        replace<F>(containerViewId)
    }
}
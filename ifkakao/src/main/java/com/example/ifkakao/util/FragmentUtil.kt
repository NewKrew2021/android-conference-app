package com.example.ifkakao.util

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

inline fun <reified F : Fragment> Fragment.replaceTransaction(containerViewId: Int) {
    parentFragmentManager.commit {
        setReorderingAllowed(true)
        addToBackStack(null)
        replace<F>(containerViewId)
    }
}

inline fun <reified F : Fragment> Fragment.addTransaction(containerViewId: Int) {
    parentFragmentManager.commit {
        setReorderingAllowed(true)
        addToBackStack(null)
        add<F>(containerViewId)
    }
}

fun Fragment.showToast(message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}
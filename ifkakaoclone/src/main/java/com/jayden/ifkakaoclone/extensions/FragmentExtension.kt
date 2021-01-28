package com.jayden.ifkakaoclone.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

inline fun <reified F : Fragment> Fragment.replaceTransaction(fragmentContainerViewId: Int) {
    parentFragmentManager.commit {
        setReorderingAllowed(true)
        replace<F>(fragmentContainerViewId)
        addToBackStack(null)
    }
}

fun Fragment.finish() {
    parentFragmentManager.popBackStack()
}

fun Fragment.showToastMessage(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}
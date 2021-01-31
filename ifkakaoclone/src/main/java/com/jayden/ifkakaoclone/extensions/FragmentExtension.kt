package com.jayden.ifkakaoclone.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

//inline fun <reified F : Fragment> Fragment.replaceTransaction(fragmentContainerViewId: Int) {
//    parentFragmentManager.commit {
//        setReorderingAllowed(true)
//        replace<F>(fragmentContainerViewId)
//        addToBackStack(null)
//    }
//}

fun Fragment.finish() = findNavController().navigateUp()

fun Fragment.showToastMessage(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}
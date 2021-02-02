package com.survivalcoding.ifkakao.extension

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.NavHostFragment
import kotlin.reflect.KClass

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

fun Fragment.replaceFragmentWithBundle(containerViewId: Int, kClass: KClass<out Fragment>, bundle: Bundle) {
    parentFragmentManager.commit {
        setReorderingAllowed(true)
        addToBackStack(null)
        replace(
            containerViewId,
            kClass.java,
            bundle
        )
    }
}

fun Fragment.navigate(resId : Int): Unit =
    NavHostFragment.findNavController(this).navigate(resId)

fun Fragment.navigate(resId : Int, bundle: Bundle): Unit =
    NavHostFragment.findNavController(this).navigate(resId, bundle)

fun Fragment.popBackStack(): Boolean =
    NavHostFragment.findNavController(this).popBackStack()

fun Fragment.popBackStack(fragment: Fragment): Boolean =
    NavHostFragment.findNavController(fragment).popBackStack()
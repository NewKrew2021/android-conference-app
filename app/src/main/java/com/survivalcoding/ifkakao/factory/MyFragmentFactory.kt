package com.survivalcoding.ifkakao.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.MainFragment
import com.survivalcoding.ifkakao.detailFragment

class MyFragmentFactory() : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            MainFragment::class.java -> MainFragment()
            detailFragment::class.java -> detailFragment()


            else -> super.instantiate(classLoader, className)
        }
    }
}
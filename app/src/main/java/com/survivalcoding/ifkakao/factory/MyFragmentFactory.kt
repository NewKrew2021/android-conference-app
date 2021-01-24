package com.survivalcoding.ifkakao.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.MainFragment
import com.survivalcoding.ifkakao.DetailFragment

class MyFragmentFactory() : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            MainFragment::class.java -> MainFragment()
            DetailFragment::class.java -> DetailFragment()


            else -> super.instantiate(classLoader, className)
        }
    }
}
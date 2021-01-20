package com.survivalcoding.ifkakao.second.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.second.view.main.MainFragment

class ContentFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            MainFragment::class.java -> MainFragment()
            else -> super.instantiate(classLoader, className)
        }
    }

}
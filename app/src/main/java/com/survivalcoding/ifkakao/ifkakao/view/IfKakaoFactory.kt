package com.survivalcoding.ifkakao.ifkakao.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.ifkakao.view.main.IfKakaoFragment
import com.survivalcoding.ifkakao.ifkakao.view.presentation.PresentationFragment

class IfKakaoFactory() : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            IfKakaoFragment::class.java.name -> IfKakaoFragment()
            PresentationFragment::class.java.name -> PresentationFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}
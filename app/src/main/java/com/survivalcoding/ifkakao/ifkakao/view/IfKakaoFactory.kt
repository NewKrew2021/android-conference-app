package com.survivalcoding.ifkakao.ifkakao.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.view.main.IfKakaoFragment

class IfKakaoFactory() : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            IfKakaoFragment::class.java.name -> IfKakaoFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}
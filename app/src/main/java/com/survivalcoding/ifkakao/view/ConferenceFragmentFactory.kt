package com.survivalcoding.ifkakao.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel

class ConferenceFragmentFactory(private val viewModel: ConferenceViewModel) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            MainFragment::class.java -> MainFragment(viewModel)
            else -> super.instantiate(classLoader, className)
        }
    }
}
package com.survivalcoding.ifkakao.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.repository.Repository
import com.survivalcoding.ifkakao.view.ConferenceListFragment

class ConferenceFragmentFactory(val repository: Repository) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(loadFragmentClass(classLoader, className)){
            ConferenceListFragment::class.java -> ConferenceListFragment(repository)
            else -> super.instantiate(classLoader, className)
        }
    }
}
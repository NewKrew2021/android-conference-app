package com.survivalcoding.ifkakao.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.data.repository.Repository
import com.survivalcoding.ifkakao.view.main.fragment.ConferenceListFragment

class ConferenceFragmentFactory(private val repository: Repository) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(loadFragmentClass(classLoader, className)) {
            ConferenceListFragment::class.java -> ConferenceListFragment(repository)
            else -> super.instantiate(classLoader, className)
        }
    }
}

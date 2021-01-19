package com.survivalcoding.ifkakao.first.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.first.model.repository.Repository
import com.survivalcoding.ifkakao.first.view.ListFragment

class ConferenceFragmentFactory(private val repository: Repository) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            ListFragment::class.java -> ListFragment(repository)
            else -> super.instantiate(classLoader, className)
        }
    }

}
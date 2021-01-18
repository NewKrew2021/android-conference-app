package com.survivalcoding.ifkakao.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.repository.Repository
import com.survivalcoding.ifkakao.view.ListFragment

class ConferenceFragmentFactory(val repository: Repository) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(loadFragmentClass(classLoader, className)){
            ListFragment::class.java -> ListFragment(repository)
            else -> super.instantiate(classLoader, className)
        }
    }
}
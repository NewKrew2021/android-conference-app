package com.survivalcoding.ifkakao.first.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.first.model.repository.Repository
import com.survivalcoding.ifkakao.first.view.main.MainFragment

class ConferenceFragmentFactory(private val repository: Repository) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            MainFragment::class.java -> MainFragment(repository)
            else -> super.instantiate(classLoader, className)
        }
    }

}
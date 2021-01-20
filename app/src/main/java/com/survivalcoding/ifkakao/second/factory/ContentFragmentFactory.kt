package com.survivalcoding.ifkakao.second.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.second.model.repository.Repository
import com.survivalcoding.ifkakao.second.view.main.MainFragment
import com.survivalcoding.ifkakao.second.viewmodel.ContentViewModel

class ContentFragmentFactory(private val repository: Repository) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            MainFragment::class.java -> MainFragment(ContentViewModel(repository))
            else -> super.instantiate(classLoader, className)
        }
    }

}
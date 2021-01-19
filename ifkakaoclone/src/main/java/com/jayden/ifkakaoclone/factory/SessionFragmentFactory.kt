package com.jayden.ifkakaoclone.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.jayden.ifkakaoclone.data.repository.Repository
import com.jayden.ifkakaoclone.view.main.fragment.SessionListFragment

class SessionFragmentFactory(private val repository: Repository) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            SessionListFragment::class.java -> SessionListFragment(repository)
            else -> super.instantiate(classLoader, className)
        }
    }
}
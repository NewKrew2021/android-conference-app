package com.survivalcoding.ifkakao.conference.view.main.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.survivalcoding.ifkakao.conference.data.DataModelItem
import com.survivalcoding.ifkakao.conference.view.conference.ConferenceFragment
import com.survivalcoding.ifkakao.conference.view.main.ConferenceListFragment

class ConferenceFactory(private val data: List<DataModelItem>) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            ConferenceListFragment::class.java.name -> ConferenceListFragment(data)
            ConferenceFragment::class.java.name -> ConferenceFragment(data)
            else -> super.instantiate(classLoader, className)
        }
    }
}
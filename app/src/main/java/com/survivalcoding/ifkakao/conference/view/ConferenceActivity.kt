package com.survivalcoding.ifkakao.conference.view

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.conference.data.DataModel
import com.survivalcoding.ifkakao.conference.data.DataModelItem
import com.survivalcoding.ifkakao.conference.view.main.ConferenceListFragment
import com.survivalcoding.ifkakao.conference.view.main.factory.ConferenceFactory

class ConferenceActivity : AppCompatActivity(R.layout.activity_conference) {
    private val conferenceList: List<DataModelItem> by lazy { DataModel().get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = ConferenceFactory(conferenceList)
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val fragment = supportFragmentManager.fragmentFactory.instantiate(
                classLoader,
                ConferenceListFragment::class.java.name
            )
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.conference_fragment, fragment)
            }
        }
    }
}
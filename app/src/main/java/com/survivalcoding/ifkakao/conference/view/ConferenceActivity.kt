package com.survivalcoding.ifkakao.conference.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.conference.data.DataModel
import com.survivalcoding.ifkakao.conference.data.DataModelItem
import com.survivalcoding.ifkakao.conference.view.main.ConferenceListFragment

class ConferenceActivity: AppCompatActivity(R.layout.activity_conference) {
    private val conferenceList: List<DataModelItem> by lazy { DataModel().get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ConferenceListFragment>(R.id.conference_fragment)
            }
        }
    }
}
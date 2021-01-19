package com.survivalcoding.ifkakao.conference.view.conference

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.conference.data.DataModelItem

class ConferenceFragment(private val data: List<DataModelItem>) :
    Fragment(R.layout.fragment_conference) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val index = Bundle().getInt("item")
    }
}
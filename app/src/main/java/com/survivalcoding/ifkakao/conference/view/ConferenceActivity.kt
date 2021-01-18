package com.survivalcoding.ifkakao.conference.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.survivalcoding.ifkakao.conference.data.DataModel
import com.survivalcoding.ifkakao.conference.data.DataModelItem
import com.survivalcoding.ifkakao.conference.view.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.databinding.ActivityConferenceBinding

class ConferenceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConferenceBinding
    private val conferenceList: List<DataModelItem> by lazy { DataModel().get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val conferenceAdapter by lazy {
            ConferenceAdapter(conferenceList)
        }

        binding.conferenceList.adapter = conferenceAdapter
        conferenceAdapter.submitList(conferenceList)
    }
}
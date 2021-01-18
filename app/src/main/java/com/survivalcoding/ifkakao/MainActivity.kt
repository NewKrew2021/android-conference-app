package com.survivalcoding.ifkakao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.model.ConferenceRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = ConferenceAdapter(ConferenceRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeView()
    }

    private fun initializeView() {
        binding.apply {
            conferenceRecyclerView.adapter = adapter
            // 구분선 추가
            conferenceRecyclerView.addItemDecoration(
                DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
            )
        }
    }
}
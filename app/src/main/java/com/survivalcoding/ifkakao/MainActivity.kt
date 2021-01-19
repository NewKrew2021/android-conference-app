package com.survivalcoding.ifkakao

import android.content.ContentValues
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import com.survivalcoding.ifkakao.view.adapter.RecyclerAdapter
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter
    val conferenceRepository = ConferenceRepository()
    var finishDownload: String by Delegates.observable("initValue") { props, old, new ->

        updateRecycler(conferenceRepository.listData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        conferenceRepository.isFinish=finishDownload

        conferenceRepository.getData()

        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        updateRecycler(conferenceRepository.listData)
    }

    fun updateRecycler(data : MutableList<ConferenceAppFront>){
        Thread.sleep(1000) //임시로 해놓
        adapter.submitList(data.toList())
    }
}
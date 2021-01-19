package com.survivalcoding.ifkakao.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ConferenceViewModel
    private var adapter = ConferenceAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ConferenceViewModel(ConferenceRepository())

        binding.recyclerview.apply {
            adapter = this@MainActivity.adapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        binding.testButton.setOnClickListener {

            Thread {
                val data =
//                    getDataFrom("https://raw.githubusercontent.com/junsuk5/mock_json/main/conferences.json")
                    getDataFrom("https://raw.githubusercontent.com/junsuk5/mock_json/main/conf/contents.json")

                runOnUiThread {
                    updateUiByData(data)
                }
            }.start()
        }
    }

    private fun updateUiByData(data: String) {
        adapter.submitList(viewModel.getConferences(data))
//        adapter.submitList(viewModel.getSamples())
    }

    private fun getDataFrom(url: String): String {
        val request = Request.Builder().url(url).build()
        OkHttpClient().newCall(request).execute().use {
            return it.body!!.string()
        }
    }

}
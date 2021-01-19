package com.survivalcoding.ifkakao.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel
import okhttp3.OkHttpClient
import okhttp3.Request

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ConferenceAdapter
    private lateinit var viewModel: ConferenceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        adapter = ConferenceAdapter()
        viewModel = ConferenceViewModel(ConferenceRepository())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

        binding.recyclerview.apply {
            adapter = this@MainFragment.adapter
            addItemDecoration(
                DividerItemDecoration(
                    requireActivity(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        loadConferencesFromServer()
    }

    private fun loadConferencesFromServer() {
        Thread {
            val data =
                getDataFrom("https://raw.githubusercontent.com/junsuk5/mock_json/main/conf/contents.json")

            requireActivity().runOnUiThread {
                updateUiByData(data)
            }
        }.start()
    }

    private fun updateUiByData(data: String) {
        adapter.submitList(viewModel.getConferences(data))
    }

    private fun getDataFrom(url: String): String {
        val request = Request.Builder().url(url).build()
        OkHttpClient().newCall(request).execute().use {
            return it.body!!.string()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
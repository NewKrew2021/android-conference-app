package com.survivalcoding.ifkakao.view

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.VideoView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.adapter.ConferenceListAdapter
import com.survivalcoding.ifkakao.adapter.SpinnerAdapter
import com.survivalcoding.ifkakao.databinding.FragmentConferenceListBinding
import com.survivalcoding.ifkakao.model.conferenceData.Data
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel


class ConferenceListFragment() : Fragment() {
    private var _bindng: FragmentConferenceListBinding? = null
    lateinit var conferenceListAdapter: ConferenceListAdapter
    private val binding get() = _bindng!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindng = FragmentConferenceListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        conferenceListAdapter = ConferenceListAdapter()
        val dividerItemDecoration = DividerItemDecoration(
            context,
            DividerItemDecoration.VERTICAL
        )
        ResourcesCompat.getDrawable(requireContext().resources, R.drawable.custom_divider, null)
            ?.let {
                dividerItemDecoration.setDrawable(it)
            }

        binding.apply {
            playVideoTeaser(teaser)
            conferenceListView.addItemDecoration(
                dividerItemDecoration
            )
            conferenceListView.adapter = conferenceListAdapter
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.spinner_filter,
                R.layout.spinner_item
            ).also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = it
            }
            spinner.setSelection(2)
            spinner.onItemSelectedListener = SpinnerAdapter()
        }

        val viewModel: ConferenceViewModel by viewModels()
        viewModel.list.observe(viewLifecycleOwner, Observer<List<Data>> {
            updateList(it)
        })
        viewModel.loadData()

    }

    private fun updateList(list: List<Data>) {
        conferenceListAdapter.submitList(list)
    }

    private fun playVideoTeaser(videoView: VideoView) {
        val videoUri =
            Uri.parse("https://t1.kakaocdn.net/service_if_kakao_prod/videos/mo/vod_teaser.mp4")
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()
        videoView.setOnPreparedListener {
            videoView.start()
            it.isLooping = true
        }
    }


}
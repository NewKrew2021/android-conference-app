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
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
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
    val viewModel: ConferenceViewModel by activityViewModels()

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
        conferenceListAdapter = ConferenceListAdapter(
                showDetail = {
                    viewModel.setSelectItem(it)
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragmentContainerView, DetailFragment())
                        addToBackStack(null)
                    }
                }
        )
        val dividerItemDecoration = DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
        )
        ResourcesCompat.getDrawable(requireContext().resources, R.drawable.custom_divider, null)
                ?.let {
                    dividerItemDecoration.setDrawable(it)
                }
        binding.apply {
            //Setting viewModel
            viewModels = viewModel
            lifecycleOwner = this@ConferenceListFragment
            //video Teaser
            playVideoTeaser(teaser)

            //Recycler View
            conferenceListView.addItemDecoration(
                    dividerItemDecoration
            )
            conferenceListView.adapter = conferenceListAdapter

            //spinner
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

            fieldFilterButton.setOnClickListener {
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainerView, FilterFragment())
                    addToBackStack(null)
                }
            }
        }

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
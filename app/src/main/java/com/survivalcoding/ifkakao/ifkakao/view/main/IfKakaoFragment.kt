package com.survivalcoding.ifkakao.ifkakao.view.main

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.VideoView
import androidx.core.net.toUri
import androidx.core.view.MenuCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentCoordinatorBinding
import com.survivalcoding.ifkakao.databinding.FragmentIfKakaoBinding
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.view.main.adapter.IfKakaoAdapter
import com.survivalcoding.ifkakao.ifkakao.viewmodel.IfKakaoViewModel

class IfKakaoFragment() : Fragment() {
    private var _binding: FragmentCoordinatorBinding? = null
    private val binding get() = _binding!!

    val adapter = IfKakaoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoordinatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            ifKakaoListView.adapter = adapter

            // spinner
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.day_select,
                R.layout.item_spinner
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                daySelectSpinner.adapter = adapter
            }

            // filter button
            filterButton.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "filter button clicked - IfKakaoFragment",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // video view
            teaserPlay(vodTeaser)
        }

        // ViewModel 가져오기.
        val model: IfKakaoViewModel by viewModels()
        // LiveData가 수정될 때 실행할 메소드
        model.ifKakaoSessionList.observe(viewLifecycleOwner, Observer {
            updateUi(it.data)
        })

        model.loadIfKakaoItem()
    }

    fun teaserPlay(videoView: VideoView) {
        videoView.setVideoURI("https://t1.kakaocdn.net/service_if_kakao_prod/videos/mo/vod_teaser.mp4".toUri())
        videoView.setOnPreparedListener {
            videoView.start()
            it.isLooping = true;
        }
    }

    fun updateUi(list: List<Data>) {
        adapter.submitList(list)
    }
}
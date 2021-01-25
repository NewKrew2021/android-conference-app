package com.example.ifkakao.view

import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ifkakao.R
import com.example.ifkakao.adapter.SessionAdapter
import com.example.ifkakao.databinding.FragmentMainBinding
import com.example.ifkakao.util.replaceTransaction
import com.example.ifkakao.viewmodel.SessionViewModel

/*
TODO: 1. 네트워크 통신 구현
      2. 필터링 기능 추가
 */
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SessionViewModel by activityViewModels()
    private lateinit var adapter: SessionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.let {
            it.lifecycleOwner = this
            it.viewModel = viewModel
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.filterButton.setOnClickListener {
            replaceTransaction<FilterFragment>(R.id.fragment_container_view)
        }
    }

    private fun initializeView() {
        adapter = SessionAdapter(
            sessionClickListener = {
                viewModel.setSelectedSession(it)
                replaceTransaction<SessionInfoFragment>(R.id.fragment_container_view)
            },
            upButtonClickListener = {
                binding.conferenceRecyclerView.smoothScrollToPosition(0)
            }
        )
        binding.apply {
            conferenceRecyclerView.adapter = adapter
            setVideoView()
        }
        viewModel.updateSessionData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setVideoView() {
        binding.mainVideo.apply {
            // 화면이 세로 상태
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                setVideoURI(Uri.parse(VIDEO_PORTRAIT_URL))
                layoutParams.height = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    VIDEO_PORTRAIT_HEIGHT,
                    resources.displayMetrics
                ).toInt()
            } else { // 화면 가로 상태
                setVideoURI(Uri.parse(VIDEO_LANDSCAPE_URL))
                layoutParams.height = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    VIDEO_LANDSCAPE_HEIGHT,
                    resources.displayMetrics
                ).toInt()
            }
            setOnPreparedListener { it.start() }
            setOnCompletionListener { it.start() }
        }
    }

    companion object {
        const val VIDEO_PORTRAIT_HEIGHT = 411F
        const val VIDEO_PORTRAIT_URL =
            "https://t1.kakaocdn.net/service_if_kakao_prod/videos/mo/vod_teaser.mp4"
        const val VIDEO_LANDSCAPE_HEIGHT = 292F
        const val VIDEO_LANDSCAPE_URL =
            "https://t1.kakaocdn.net/service_if_kakao_prod/videos/pc/vod_teaser.mp4"
    }
}
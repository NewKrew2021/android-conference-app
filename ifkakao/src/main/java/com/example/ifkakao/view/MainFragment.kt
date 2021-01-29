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
import com.example.ifkakao.util.addTransaction
import com.example.ifkakao.util.showToast
import com.example.ifkakao.viewmodel.ErrorStatus
import com.example.ifkakao.viewmodel.SessionViewModel

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
        observeData()
    }

    private fun observeData() {
        viewModel.errorStatus.observe(viewLifecycleOwner) {
            when (it) {
                ErrorStatus.CLIENT_ERROR -> showToast(getString(R.string.client_error))
                ErrorStatus.SERVER_ERROR -> showToast(getString(R.string.server_error))
                ErrorStatus.UNKNOWN_ERROR -> showToast(getString(R.string.unknown_error))
                else -> Unit // else 가 없으면 warning 이 발생해서 추가
            }
        }
    }

    private fun setOnClickListener() {
        binding.filterButton.setOnClickListener {
            addTransaction<FilterFragment>(R.id.fragment_container_view)
        }
        binding.favoriteSessionButton.setOnClickListener {
            addTransaction<FavoriteSessionFragment>(R.id.fragment_container_view)
        }
    }

    private fun initializeView() {
        adapter = SessionAdapter(
            sessionClickListener = {
                viewModel.setSelectedSession(it)
                addTransaction<SessionInfoFragment>(R.id.fragment_container_view)
            },
            upButtonClickListener = {
                binding.conferenceRecyclerView.scrollToPosition(0)
            }
        )
        binding.apply {
            conferenceRecyclerView.adapter = adapter
            setVideoView()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setVideoView() {
        binding.mainVideo.apply {
            // 화면이 세로 상태
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                val video = Uri.parse(
                    String.format(
                        VIDEO_URL,
                        requireActivity().packageName,
                        R.raw.main_video_portrait
                    )
                )
                setVideoURI(video)
                layoutParams.height = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    VIDEO_PORTRAIT_HEIGHT,
                    resources.displayMetrics
                ).toInt()
            } else { // 화면 가로 상태
                val video = Uri.parse(
                    String.format(
                        VIDEO_URL,
                        requireActivity().packageName,
                        R.raw.main_video_landscape
                    )
                )
                setVideoURI(video)
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
        const val VIDEO_PORTRAIT_HEIGHT = 360F
        const val VIDEO_URL = "android.resource://%s/%d"
        const val VIDEO_LANDSCAPE_HEIGHT = 292F
    }
}
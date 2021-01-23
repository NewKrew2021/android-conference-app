package com.jayden.ifkakaoclone.view.main.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.jayden.ifkakaoclone.data.viewmodel.SessionViewModel
import com.jayden.ifkakaoclone.databinding.FragmentSessionDetailBinding

class SessionDetailFragment : Fragment() {
    private var _binding: FragmentSessionDetailBinding? = null
    private val binding
        get() =_binding!!

    private val activityViewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSessionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel = activityViewModel

            btnBackToList.setOnClickListener {
                parentFragmentManager.popBackStack()
            }

            layoutFooter.imageScrollTop.setOnClickListener {
                nestedScrollView.smoothScrollTo(0, 0)
            }

            imageVideoPlay.setOnClickListener {
                playVideo()
            }
        }
    }

    private fun playVideo() {
        activityViewModel.selectedItem.value?.linkList?.video?.let {
            if (it.isNotEmpty()) {
                val video = it[0]
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(video.url))
                startActivity(intent)
            }
        }
    }
}
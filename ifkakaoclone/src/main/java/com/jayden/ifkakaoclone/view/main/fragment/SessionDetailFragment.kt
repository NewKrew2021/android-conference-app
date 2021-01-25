package com.jayden.ifkakaoclone.view.main.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.jayden.ifkakaoclone.data.viewmodel.SessionViewModel
import com.jayden.ifkakaoclone.databinding.FragmentSessionDetailBinding
import com.jayden.ifkakaoclone.view.main.adapter.ContentSpeakerAdapter

class SessionDetailFragment : Fragment() {
    private var _binding: FragmentSessionDetailBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        ContentSpeakerAdapter()
    }

    private val activityViewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSessionDetailBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@SessionDetailFragment
            viewModel = activityViewModel
            fragment = this@SessionDetailFragment
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            speakerRecyclerView.adapter = adapter

            layoutFooter.textIfkakao2019.setOnClickListener {
                openIfKakao2019()
            }

            layoutFooter.imageScrollTop.setOnClickListener {
                nestedScrollView.smoothScrollTo(0, 0)
            }
        }

        // n Configuration Change is notified again
        // so Sending Events with OneTime Only LiveData
        activityViewModel.action.observe(viewLifecycleOwner) {
            playVideoByBrowser(it.url)
        }

        updateSpeaker()
    }

    private fun playVideoByBrowser(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    private fun updateSpeaker() {
        activityViewModel.selectedItem.value?.let {
            adapter.setItems(it.contentsSpeackerList.zip(it.linkList.speackerProfile))
            adapter.notifyDataSetChanged()
        }
    }

    private fun openIfKakao2019() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://if.kakao.com/2019"))
        startActivity(intent)
    }
}
package com.survivalcoding.ifkakao.second.view.main

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.survivalcoding.ifkakao.databinding.SecondFragmentDetailBinding
import com.survivalcoding.ifkakao.second.extension.removeTag
import com.survivalcoding.ifkakao.second.model.content.Speaker
import com.survivalcoding.ifkakao.second.view.detail.adapter.SpeakerDetailAdapter
import com.survivalcoding.ifkakao.second.viewmodel.ContentViewModel


class DetailFragment : Fragment() {
    private var _binding: SecondFragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ContentViewModel by activityViewModels()
    private val adapter by lazy {
        SpeakerDetailAdapter(
            contentData = viewModel.selectedItem,
            favorite = viewModel.selectedFavorite,
            videoPlayListener = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                startActivity(intent)
            },
            favoriteClickListener = {
                viewModel.updateFavorite(it)
            },
            kakaoClickListenr = { title: String, idx: Int ->
            },
            facebookClickListener = { title: String, idx: Int ->
            },
            linkClickListener = { title: String, idx: Int ->
            },
            copyClickListener = { title: String, idx: Int ->
                // 해당 세션 주소 클립보드에 저장
                val clipboardManager: ClipboardManager =
                    requireContext().getSystemService(Activity.CLIPBOARD_SERVICE) as ClipboardManager
                val clipData: ClipData =
                    ClipData.newPlainText(
                        "If(kakao) ${title.removeTag()}",
                        "https://if.kakao.com/session/${idx}"
                    )
                clipboardManager.setPrimaryClip(clipData)
                Toast.makeText(requireContext(), "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show()
            },
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentDetailBinding.inflate(inflater, container, false)
        requireActivity().title = "if(kakao)2020"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        viewModel.speakers.observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI(data: List<Speaker>) {
        adapter.submitListWithHeader(data)
    }

}
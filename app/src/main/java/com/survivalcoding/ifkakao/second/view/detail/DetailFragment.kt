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
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.survivalcoding.ifkakao.databinding.SecondFragmentDetailBinding
import com.survivalcoding.ifkakao.second.App
import com.survivalcoding.ifkakao.second.extension.removeTag
import com.survivalcoding.ifkakao.second.model.content.Speaker
import com.survivalcoding.ifkakao.second.model.favorite.repository.FavoriteRepository
import com.survivalcoding.ifkakao.second.view.detail.adapter.SpeakerDetailAdapter
import com.survivalcoding.ifkakao.second.viewmodel.FavoriteViewModel


class DetailFragment : Fragment() {
    private var _binding: SecondFragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: FavoriteViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(
                    FavoriteRepository::class.java,
                ).newInstance(
                    (requireActivity().application as App).favoriteRepository,
                )
            }
        }
    }
    private val adapter by lazy {
        SpeakerDetailAdapter(
            contentData = args.contentData,
            favorite = viewModel.selectedFavorite,
            videoPlayListener = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                startActivity(intent)
            },
            favoriteClickListener = {
                viewModel.updateFavorite(it)
            },
            kakaoClickListenr = { title: String, idx: Int ->
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TITLE, title.removeTag())
                    putExtra(Intent.EXTRA_TEXT, "https://if.kakao.com/session/${idx}")
                    setPackage("com.kakao.talk")
                }
                val chooser = Intent.createChooser(intent, title.removeTag())
                startActivity(chooser)
            },
            facebookClickListener = { title: String, idx: Int ->
            },
            linkClickListener = { title: String, idx: Int ->
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TITLE, title.removeTag())
                    putExtra(Intent.EXTRA_TEXT, "https://if.kakao.com/session/${idx}")
                }
                val chooser = Intent.createChooser(intent, title.removeTag())
                startActivity(chooser)
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
        viewModel.loadData(args.contentData.idx)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        updateUI(args.contentData.contentsSpeackerList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI(data: List<Speaker>) {
        adapter.submitListWithHeader(data)
    }

}
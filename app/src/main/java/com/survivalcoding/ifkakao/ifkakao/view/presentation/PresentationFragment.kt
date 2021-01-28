package com.survivalcoding.ifkakao.ifkakao.view.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.survivalcoding.ifkakao.databinding.FragmentPresentationBinding
import com.survivalcoding.ifkakao.ifkakao.database.FavoriteTable
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.model.speakermodel.PresenterInfo
import com.survivalcoding.ifkakao.ifkakao.view.presentation.adapter.PresentationAdapter
import com.survivalcoding.ifkakao.ifkakao.viewmodel.FavoriteViewModel
import com.survivalcoding.ifkakao.ifkakao.viewmodel.IfKakaoViewModel

class PresentationFragment : Fragment() {
    private var _binding: FragmentPresentationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: IfKakaoViewModel by activityViewModels()
    private val favoriteViewModel: FavoriteViewModel by activityViewModels()
    private lateinit var presentationData: Data

    private val adapter = PresentationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPresentationBinding.inflate(inflater, container, false)

        viewModel.presentationData.value?.let { presentationData = it }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.presentationData = presentationData
        binding.presenterList.adapter = adapter

        var isFavorite: Boolean = false
        binding.isFavorite = isFavorite

        favoriteViewModel.isFavoriteSession(presentationData.idx)

        binding.favoriteButton.setOnClickListener {
            favoriteViewModel.updateFavorite(presentationData.idx, isFavorite)
        }

        val presentItem = mutableListOf<PresenterInfo>()
        presentationData.let {
            for (i in presentationData.linkList.SPEACKER_PROFILE.indices) {
                val imageUrl = presentationData.linkList.SPEACKER_PROFILE[i].url
                val contentsSpeaker = presentationData.contentsSpeackerList[i]

                presentItem.add(PresenterInfo(contentsSpeaker, imageUrl))
            }
        }
        presentItem.add(presentItem[0])
        updatePresenter(presentItem)

        favoriteViewModel.isFavorite.observe(viewLifecycleOwner, Observer {
            isFavorite = it
            binding.isFavorite = isFavorite
        })
    }

    private fun updatePresenter(item: List<PresenterInfo>) {
        adapter.submitList(item)
    }
}
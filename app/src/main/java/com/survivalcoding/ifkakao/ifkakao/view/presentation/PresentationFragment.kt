package com.survivalcoding.ifkakao.ifkakao.view.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentPresentationBinding
import com.survivalcoding.ifkakao.ifkakao.database.FavoriteTable
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.model.speakermodel.PresenterInfo
import com.survivalcoding.ifkakao.ifkakao.view.presentation.adapter.PresentationAdapter
import com.survivalcoding.ifkakao.ifkakao.view.sorted.SortedListFragment
import com.survivalcoding.ifkakao.ifkakao.viewmodel.FavoriteViewModel
import com.survivalcoding.ifkakao.ifkakao.viewmodel.IfKakaoViewModel

class PresentationFragment : Fragment() {
    private var _binding: FragmentPresentationBinding? = null
    private val binding get() = _binding!!

    private val favoriteViewModel: FavoriteViewModel by activityViewModels()

    private val adapter = PresentationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPresentationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: PresentationFragmentArgs by navArgs()
        val presentationData: Data = args.presentationData
        binding.presentationData = presentationData
        binding.onClickFragment = this@PresentationFragment
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
            binding.isFavorite = it
        })
    }

    private fun updatePresenter(item: List<PresenterInfo>) {
        adapter.submitList(item)
    }

    fun textListener(title: String) {
        val action =
            PresentationFragmentDirections.actionPresentationFragmentToSortedListFragment(title)
        findNavController().navigate(action)
    }
}
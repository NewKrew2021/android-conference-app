package com.survivalcoding.ifkakao.ifkakao.view.sorted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.survivalcoding.ifkakao.databinding.FragmentSortedListBinding
import com.survivalcoding.ifkakao.ifkakao.view.main.adapter.IfKakaoAdapter
import com.survivalcoding.ifkakao.ifkakao.viewmodel.FavoriteViewModel
import com.survivalcoding.ifkakao.ifkakao.viewmodel.IfKakaoViewModel

class FavoriteListFragment : Fragment() {
    private var _binding: FragmentSortedListBinding? = null
    private val binding get() = _binding!!

    private val model: IfKakaoViewModel by activityViewModels()
    private val favoriteViewModel: FavoriteViewModel by activityViewModels()

    private val adapter: IfKakaoAdapter = IfKakaoAdapter({
        // java.lang.IllegalStateException: View androidx.constraintlayout.widget.ConstraintLayout{a1c22a1 V.E...... ........ 0,0-1080,1868} does not have a NavController set
        val action =
            FavoriteListFragmentDirections.actionFavoriteListFragmentToPresentationFragment(it)
        findNavController().navigate(action)
    }, {
        val action =
            FavoriteListFragmentDirections.actionFavoriteListFragmentToSortedListFragment(it)
        findNavController().navigate(action)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSortedListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.itemText = "Favorite"
        binding.sortedItemList.adapter = adapter

        val presentationList = model.ifKakaoSessionList.value?.data
        favoriteViewModel.favoriteList.observe(viewLifecycleOwner, Observer {
            val favoriteIdxList = it.map { favoriteTable -> favoriteTable.idx }
            val favoriteList =
                presentationList?.filter { data -> favoriteIdxList.any { idx -> idx == data.idx } }
            adapter.submitList(favoriteList)
        })

        favoriteViewModel.getAllFavoriteList()
    }
}
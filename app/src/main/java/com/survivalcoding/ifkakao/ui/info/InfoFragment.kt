package com.survivalcoding.ifkakao.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentInfoBinding
import com.survivalcoding.ifkakao.extension.openFragmentWith
import com.survivalcoding.ifkakao.extension.openMainFragment
import com.survivalcoding.ifkakao.extension.popThis
import com.survivalcoding.ifkakao.ui.favorite.FavoriteFragment

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.closeButton.setOnClickListener {
            popThis()
        }
        binding.allSession.setOnClickListener {
            openMainFragment()
        }
        binding.favorites.setOnClickListener {
            openFragmentWith<FavoriteFragment>()
        }
    }
}
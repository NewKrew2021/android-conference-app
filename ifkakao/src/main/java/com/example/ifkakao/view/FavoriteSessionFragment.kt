package com.example.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ifkakao.databinding.FragmentFavoriteSessionBinding

class FavoriteSessionFragment : Fragment() {
    private var _binding: FragmentFavoriteSessionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteSessionBinding.inflate(inflater, container, false)
        return binding.root
    }
}
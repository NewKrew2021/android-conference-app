package com.example.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.ifkakao.R
import com.example.ifkakao.adapter.SessionAdapter
import com.example.ifkakao.databinding.FragmentFavoriteSessionBinding
import com.example.ifkakao.util.addTransaction
import com.example.ifkakao.viewmodel.SessionViewModel

class FavoriteSessionFragment : Fragment() {
    private var _binding: FragmentFavoriteSessionBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SessionAdapter
    private val viewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteSessionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        observeData()
        viewModel.updateFavoriteSessionList()
    }

    private fun observeData() {
        viewModel.favoriteSessionList.observe(viewLifecycleOwner) {
            adapter.setItemList(it)
        }
    }

    private fun initializeView() {
        Glide.with(binding.topGifImage)
            .load(R.drawable.intro_motion01)
            .into(binding.topGifImage)
        Glide.with(binding.bottomGifImage)
            .load(R.drawable.intro_motion02)
            .into(binding.bottomGifImage)

        adapter = SessionAdapter(sessionClickListener = {
            viewModel.setSelectedSession(it)
            addTransaction<SessionInfoFragment>(R.id.fragment_container_view)
        }, upButtonClickListener = {
            binding.favoriteScroll.fullScroll(0)
        })
        binding.favoriteRecyclerView.adapter = adapter
    }
}
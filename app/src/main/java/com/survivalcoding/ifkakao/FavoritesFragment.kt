package com.survivalcoding.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.databinding.FragmentFavoritesBinding
import com.survivalcoding.ifkakao.view.adapter.RecyclerAdapter
import com.survivalcoding.ifkakao.viewModel.ConferenceViewModel


class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    val binding get() = _binding!!
    private lateinit var adapter: RecyclerAdapter
    val conferenceViewModel: ConferenceViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFavoritesBinding.inflate(layoutInflater)
        val view = binding.root

        adapter = RecyclerAdapter() {
            conferenceViewModel.singleData.value = it

            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<DetailFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext().applicationContext)


        adapter.submitList(conferenceViewModel.getFavoritesData())


        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
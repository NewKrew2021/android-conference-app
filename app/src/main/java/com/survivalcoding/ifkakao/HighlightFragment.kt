package com.survivalcoding.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.survivalcoding.ifkakao.databinding.FragmentHighlightBinding
import com.survivalcoding.ifkakao.view.adapter.RecyclerAdapter
import com.survivalcoding.ifkakao.viewModel.ConferenceViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class HighlightFragment : Fragment() {

    private var _binding: FragmentHighlightBinding? = null
    private lateinit var adapter: RecyclerAdapter

    private val binding get() = _binding!!
    private val conferenceViewModel: ConferenceViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        conferenceViewModel.getData()

        conferenceViewModel.storeFavoritesData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHighlightBinding.inflate(layoutInflater)
        val view = binding.root


        adapter = RecyclerAdapter {

            val action = HighlightFragmentDirections.actionHighlightFragmentToDetailFragment(it)
            findNavController().navigate(action)
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext().applicationContext)

        conferenceViewModel.listData.observe(viewLifecycleOwner) {

            binding.progressBar.visibility = GONE
            adapter.submitList(conferenceViewModel.getHighlightData())
        }

        binding.totalImageView.setOnClickListener {

            findNavController().navigate(R.id.action_highlightFragment_to_mainFragment)
        }

        imageSetting()
        return view
    }

    private fun imageSetting() {
        binding.totalImageView.load(R.drawable.total_icon) {
            transformations(
                RoundedCornersTransformation(
                    topRight = 20f,
                    topLeft = 20f,
                    bottomLeft = 20f,
                    bottomRight = 20f
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.survivalcoding.ifkakao.second.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondFragmentMainBinding
import com.survivalcoding.ifkakao.second.model.content.ContentData
import com.survivalcoding.ifkakao.second.view.main.adapter.ContentMainAdapter
import com.survivalcoding.ifkakao.second.viewmodel.ContentViewModel


class MainFragment : Fragment() {
    private var _binding: SecondFragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy {
        ContentMainAdapter(
            itemClickListener = {
                val action = MainFragmentDirections.actionMainToDetail(it)
                viewModel.getFavorite(it)
                findNavController().navigate(action)
            },
            filterClickListener = {
                findNavController().navigate(R.id.action_main_to_filter)
            },
            spinnerArrayAdapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.filter_array,
                android.R.layout.simple_spinner_item
            ),
            spinnerChangeListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.setSelectedDate(3 - position)
                }
            }
        )
    }
    private val viewModel: ContentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentMainBinding.inflate(inflater, container, false)
        requireActivity().title = "if(kakao)2020"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        viewModel.filteredData.observe(viewLifecycleOwner) {
            updateUI(it)
        }
        viewModel.loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI(data: List<ContentData>) {
        adapter.submitListWithHeader(data)
    }

}
package com.survivalcoding.ifkakao.second.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondFragmentMainBinding
import com.survivalcoding.ifkakao.second.App
import com.survivalcoding.ifkakao.second.model.content.ContentData
import com.survivalcoding.ifkakao.second.model.content.Repository
import com.survivalcoding.ifkakao.second.view.main.adapter.ContentMainAdapter
import com.survivalcoding.ifkakao.second.viewmodel.ContentViewModel


class MainFragment : Fragment() {
    private var _binding: SecondFragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ContentViewModel by activityViewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(
                    Repository::class.java,
                ).newInstance(
                    (requireActivity().application as App).repository,
                )
            }
        }
    }
    private val args: MainFragmentArgs by navArgs()
    private val adapter by lazy {
        ContentMainAdapter(
            selectedDate = viewModel.selectedDate,
            itemClickListener = {
                val action = MainFragmentDirections.actionMainToDetail(it)
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
            spinnerChangeListener = {
                viewModel.setSelectedDate(it)
            }
        )
    }

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
        viewModel.loadData()
        viewModel.filteredData.observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI(data: List<ContentData>) {
        if (args.filter == null)
            adapter.submitListWithHeader(data)
        else
            args.filter?.let {
                adapter.submitListWithHeader(data, it)
            }
    }

}
package com.survivalcoding.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.view.adapter.RecyclerAdapter
import com.survivalcoding.ifkakao.viewModel.ConferenceViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private lateinit var adapter: RecyclerAdapter

    private val binding get() = _binding!!
    val conferenceViewModel: ConferenceViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        conferenceViewModel.getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        val view = binding.root

        adapter = RecyclerAdapter() {
            conferenceViewModel.singleData.value = it
            //conferenceViewModel.getSingleData(it)

            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<detailFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)

        conferenceViewModel.listData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
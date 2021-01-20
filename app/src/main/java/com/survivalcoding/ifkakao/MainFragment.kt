package com.survivalcoding.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        val view = binding.root

        //val conferenceViewModel = ConferenceViewModel()
        val conferenceViewModel: ConferenceViewModel by viewModels()

        adapter = RecyclerAdapter() {
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
        conferenceViewModel.getData()


        return view
    }


}
package com.survivalcoding.ifkakao

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
                replace<DetailFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)

        conferenceViewModel.listData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        Log.d("log2", "${requireActivity().packageName}")
        binding.videoView.setVideoURI(Uri.parse("android.resource://${requireActivity().packageName}/raw/main_video"))
        binding.videoView.setOnPreparedListener {
            it.start()
        }
        binding.videoView.setOnCompletionListener {
            it.start()
        }

        var dataArr = arrayOf("Day1", "Day2", "Day3(All)")
        var spinnerAdapter = ArrayAdapter(requireContext(), R.layout.spinner_item, dataArr)
        //var spinnerAdapter = ArrayAdapter.createFromResource(requireContext(),R.array.spinner_data,android.R.)

        binding.spinner.adapter = spinnerAdapter
        binding.spinner.onItemSelectedListener = MySpinnerListener()
        binding.spinner.setSelection(2)

        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class MySpinnerListener : AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("log2", "onItemSelected: ")
    }

}
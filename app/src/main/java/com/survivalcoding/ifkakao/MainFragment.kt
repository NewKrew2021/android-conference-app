package com.survivalcoding.ifkakao

import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.model.ConferenceAppFront
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


        setRecyclerView()
        conferenceViewModel.listData.observe(viewLifecycleOwner) {
            if (conferenceViewModel.selectInterests.size > 0) {
                var tmpList = listOf<ConferenceAppFront>()
                conferenceViewModel.selectInterests.forEach {
                    if (it == "서비스" || it == "비즈니스" || it == "기술")
                        tmpList += conferenceViewModel.getRelativeData(it, -1)
                            .map { it as ConferenceAppFront }
                }
                adapter.submitList(tmpList)
            } else {
                adapter.submitList(it)
            }
        }


        setVideoView()

        setSpinner()

        binding.imageView.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_filterFragment)
        }
        return view
    }

    fun setRecyclerView() {
        adapter = RecyclerAdapter() {

            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(it)
            findNavController().navigate(action)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireActivity().applicationContext)
    }

    fun setSpinner() {
        var dataArr = arrayOf("Day1", "Day2", "Day3(All)")
        var spinnerAdapter = ArrayAdapter(requireContext(), R.layout.spinner_item, dataArr)

        binding.spinner.apply {
            adapter = spinnerAdapter
            onItemSelectedListener = MySpinnerListener()
            setSelection(2)
        }

    }

    fun setVideoView() {
        binding.videoView.apply {
            setVideoURI(Uri.parse("android.resource://${requireActivity().packageName}/raw/main_video"))
            setOnPreparedListener {
                it.start()
            }
            setOnCompletionListener {
                it.start()
            }
        }
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
    }

}
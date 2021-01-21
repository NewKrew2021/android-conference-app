package com.survivalcoding.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.databinding.FragmentDetailBinding
import com.survivalcoding.ifkakao.model.SpeackerInfo
import com.survivalcoding.ifkakao.view.adapter.SpeakerRecyclerAdapter
import com.survivalcoding.ifkakao.viewModel.ConferenceViewModel


class detailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null

    val binding get() = _binding!!
    val conferenceViewModel: ConferenceViewModel by activityViewModels()
    private lateinit var adapter: SpeakerRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(layoutInflater)
        val view = binding.root

        val position = conferenceViewModel.currentPosition

        adapter = SpeakerRecyclerAdapter()
        binding.speakerRecyclerView.adapter = adapter
        binding.speakerRecyclerView.layoutManager =
            LinearLayoutManager(activity?.applicationContext)

        binding.fieldTextView.text = conferenceViewModel.listData.value?.get(position)?.field
        binding.titleTextView.text = conferenceViewModel.listData.value?.get(position)?.title
        binding.contentTextView.text = conferenceViewModel.listData.value?.get(position)?.content
        binding.contentTagTextView.text =
            conferenceViewModel.listData.value?.get(position)?.contentTag

        val contentsSpeackerList =
            conferenceViewModel.listData.value?.get(position)?.contentsSpeackerList
        val speackerProfileList =
            conferenceViewModel.listData.value?.get(position)?.speackerProfileList
        val speackerInfoList = mutableListOf<SpeackerInfo>()
        if (contentsSpeackerList != null && speackerProfileList != null) {
            for (i in 0..contentsSpeackerList.size - 1) {
                speackerInfoList.add(
                    SpeackerInfo(
                        contentsSpeackerList[i],
                        speackerProfileList[i].url
                    )
                )

            }
        }

        adapter.submitList(speackerInfoList)




        return view
    }


}
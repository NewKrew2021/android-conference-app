package com.survivalcoding.ifkakao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import com.survivalcoding.ifkakao.view.adapter.RecyclerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private lateinit var adapter: RecyclerAdapter

    private val binding get() = _binding!!


    val conferenceRepository = ConferenceRepository()

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

        //conferenceRepository.isFinish=finishDownload

        conferenceRepository.getData()

        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)

        updateRecycler(conferenceRepository.listData)
        return view
    }

    fun updateRecycler(data : MutableList<ConferenceAppFront>){
        Thread.sleep(1000) //임시로 해놓음
        adapter.submitList(data.toList())
    }

}
package com.survivalcoding.ifkakao.view

import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.VideoView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.adapter.ConferenceListAdapter
import com.survivalcoding.ifkakao.adapter.SpinnerAdapter
import com.survivalcoding.ifkakao.databinding.FragmentConferenceListBinding
import com.survivalcoding.ifkakao.model.conferenceData.Data
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel
import com.survivalcoding.ifkakao.viewmodel.FilterViewModel


class ConferenceListFragment() : Fragment() {
    private var _bindng: FragmentConferenceListBinding? = null
    lateinit var conferenceListAdapter: ConferenceListAdapter
    private val binding get() = _bindng!!
    val viewModel: ConferenceViewModel by activityViewModels()
    val filterViewModel: FilterViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        _bindng = FragmentConferenceListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        conferenceListAdapter = ConferenceListAdapter(
                showDetail = {
                    viewModel.setSelectItem(it)
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragmentContainerView, DetailFragment())
                        addToBackStack(null)
                    }
                }
        )
        val dividerItemDecoration = DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
        )
        ResourcesCompat.getDrawable(requireContext().resources, R.drawable.custom_divider, null)
                ?.let {
                    dividerItemDecoration.setDrawable(it)
                }
        binding.apply {
            //Setting viewModel
            viewModels = viewModel
            lifecycleOwner = requireActivity()
            //video Teaser
            playVideoTeaser(teaser)

            //Recycler View
            conferenceListView.addItemDecoration(
                    dividerItemDecoration
            )
            conferenceListView.adapter = conferenceListAdapter

            //spinner
            ArrayAdapter.createFromResource(
                    requireContext(),
                    R.array.spinner_filter,
                    R.layout.spinner_item
            ).also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = it
            }
            spinner.setSelection(2)
            spinner.onItemSelectedListener = SpinnerAdapter()

            fieldFilterButton.setOnClickListener {
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainerView, FilterFragment())
                    addToBackStack(null)
                }
            }
        }

        viewModel.list.observe(viewLifecycleOwner, Observer<List<Data>> {
            updateList(it)
        })

        filterViewModel.adaptFilter.observe(viewLifecycleOwner) {
            val list = conferenceListAdapter.currentList
            val filterList = mutableListOf<Data>()
            for (i in 0 until list.size) {
                for (j in 0 until it.size) {
                    if (list[i].contentTag?.contains(it[j]) == true) {
                        filterList.add(list[i])
                    }
                }
            }
            if(filterList.size > 0){ // filter 가 있다면
                viewModel.setFilterList(filterList)
            }else{
                viewModel.loadData()
            }

        }
        retainInstance = true

    }

    private fun updateList(list: List<Data>) {
        conferenceListAdapter.submitList(list)
        binding.conferenceListView.scrollToPosition(0)
    }

    private fun playVideoTeaser(videoView: VideoView) {
        val videoUri =
                Uri.parse("https://t1.kakaocdn.net/service_if_kakao_prod/videos/mo/vod_teaser.mp4")
        videoView.setVideoURI(videoUri)
        videoView.requestFocus()
        videoView.setOnPreparedListener {
            videoView.start()
            it.isLooping = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear();
        inflater.inflate(R.menu.actionbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigationButton-> parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerView, NavigationFragment())
                addToBackStack(null)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
package com.survivalcoding.ifkakao

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.Glide
import com.survivalcoding.ifkakao.databinding.FragmentHighlightBinding
import com.survivalcoding.ifkakao.view.adapter.RecyclerAdapter
import com.survivalcoding.ifkakao.viewModel.ConferenceViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class HighlightFragment : Fragment() {

    private var _binding: FragmentHighlightBinding? = null
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
        _binding = FragmentHighlightBinding.inflate(layoutInflater)
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
            adapter.submitList(conferenceViewModel.getHighlightData())
        }

        binding.totalImageView.setOnClickListener {

            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MainFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }

        imageSetting()

        return view
    }


    fun imageSetting() {
        binding.highlightImageView.load(R.raw.bg_bye)
        binding.highlightImageView.setImageAlpha(130)
        Glide.with(requireActivity()).load(R.raw.ico_bye).into(binding.handImageView)
        //움직이는 gif

        binding.totalImageView.load(R.raw.total_icon) {
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

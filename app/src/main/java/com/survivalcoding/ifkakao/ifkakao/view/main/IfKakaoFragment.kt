package com.survivalcoding.ifkakao.ifkakao.view.main

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.VideoView
import androidx.core.net.toUri
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentCoordinatorBinding
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.view.main.adapter.IfKakaoAdapter
import com.survivalcoding.ifkakao.ifkakao.view.presentation.PresentationFragment
import com.survivalcoding.ifkakao.ifkakao.viewmodel.IfKakaoViewModel

class IfKakaoFragment() : Fragment() {
    private var _binding: FragmentCoordinatorBinding? = null
    private val binding get() = _binding!!

    // ViewModel 가져오기.
    // 다음 fragment로 데이터를 넘겨야 할 때에는 생명주기를 activity와 같이하는 activityViewModels을 사용하자.
    val model: IfKakaoViewModel by activityViewModels()

    val adapter = IfKakaoAdapter {
        model.setPresentationData(it)
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace<PresentationFragment>(R.id.if_kakao_fragment_container_view)
            addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCoordinatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            ifKakaoListView.adapter = adapter

            // spinner
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.day_select,
                R.layout.item_spinner
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                daySelectSpinner.adapter = adapter
            }

            // filter button
            filterButton.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "filter button clicked - IfKakaoFragment",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // video view
            teaserPlay(vodTeaser)
        }

        // LiveData가 수정될 때 실행할 메소드
        model.ifKakaoSessionList.observe(viewLifecycleOwner, Observer {
            it?.let { updateUi(it.data) }
        })

        model.loadIfKakaoItem()
    }

    private fun teaserPlay(videoView: VideoView) {
        videoView.setVideoURI("https://t1.kakaocdn.net/service_if_kakao_prod/videos/mo/vod_teaser.mp4".toUri())
        videoView.setOnPreparedListener {
            videoView.start()
            it.isLooping = true;
        }
    }

    fun updateUi(list: List<Data>) {
        adapter.submitList(list)
    }
}
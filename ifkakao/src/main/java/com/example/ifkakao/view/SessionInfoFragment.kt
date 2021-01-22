package com.example.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.ifkakao.databinding.FragmentSessionInfoBinding
import com.example.ifkakao.databinding.SessionSpeakerLayoutBinding
import com.example.ifkakao.util.fromHtml
import com.example.ifkakao.viewmodel.SessionViewModel

/*
TODO: 1. Web View에 동영상 나오도록 구현
      2. Data Binding 적용
 */
class SessionInfoFragment : Fragment() {
    private var _binding: FragmentSessionInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSessionInfoBinding.inflate(inflater, container, false)
        return binding.let {
            it.lifecycleOwner = this
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        viewModel.selectedSession.observe(viewLifecycleOwner) {
            binding.apply {
                fieldText.text = it.field
                sessionTitleText.text = it.title.fromHtml()
                sessionDescribeText.text = it.content
                sessionHashTagText.text = it.contentTag

                val speakerData = it.contentsSpeakerList.zip(it.linkList.speakerProfile).toList()

                for (speaker in speakerData) {
                    val speakerBinding = SessionSpeakerLayoutBinding.inflate(
                        layoutInflater,
                        speakerListLayout,
                        false
                    )
                    speakerBinding.apply {
                        val speakerName = "${speaker.first.nameKo} ${speaker.first.nameEn}"
                        speakerNameText.text = speakerName
                        speakerCompanyText.text = speaker.first.company
                        speakerOccupationText.text = speaker.first.occupation
                        Glide.with(binding.root)
                            .load(speaker.second.url)
                            .apply(
                                RequestOptions().transform(
                                    CenterInside(),
                                    RoundedCorners(60)
                                )
                            )
                            .into(speakerBinding.speakerImage)
                    }
                    binding.speakerListLayout.addView(speakerBinding.root)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
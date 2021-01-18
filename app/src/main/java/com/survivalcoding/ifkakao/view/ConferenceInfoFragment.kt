package com.survivalcoding.ifkakao.view

import android.os.Bundle
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentConferenceInfoBinding
import com.survivalcoding.ifkakao.model.ConferenceInfo
import java.util.regex.Pattern

class ConferenceInfoFragment : Fragment() {
    private var _binding: FragmentConferenceInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConferenceInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val item = it.get(MainFragment.CONFERENCE_INFO)
            if (item is ConferenceInfo) {
                binding.apply {
                    conferenceTitleText.text = item.name
                    conferenceLocationText.text = item.location
                    startTimeText.text = item.start
                    endTimeText.text = item.end
                    addLink(item.link)
                }
            }
        }
    }

    private fun addLink(url: String) {
        val pattern = Pattern.compile(getString(R.string.official_link));
        val transformFilter = Linkify.TransformFilter { _, _ -> "" }
        Linkify.addLinks(binding.officialLinkText, pattern, url, null, transformFilter)
    }
}
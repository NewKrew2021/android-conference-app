package com.survivalcoding.ifkakao.view.main.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentConferenceDetailBinding
import com.survivalcoding.ifkakao.view.main.ActivityListener
import com.survivalcoding.ifkakao.view.main.MainActivity
import com.survivalcoding.ifkakao.view.main.model.Conference

class ConferenceDetailFragment : Fragment() {
    private var _binding: FragmentConferenceDetailBinding? = null
    private val binding
        get() = _binding!!

    private var listener: ActivityListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = (activity as MainActivity)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConferenceDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Conference>(MainActivity.CONFERENCE_ITEM_KEY)?.let { item ->
            setUpActivity(item)

            with(binding) {
                textConfLocation.text = item.location
                textConfPeriod.text = item.getPeriod()
                textLink.text = item.link
            }
        }
    }

    private fun setUpActivity(item: Conference) {
        listener?.let {
            it.setTitle(item.name)
            it.setButton(getString(R.string.fragment_conference_list_title), View.VISIBLE)
        }
    }
}
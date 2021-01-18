package com.survivalcoding.ifkakao.view.main.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.databinding.FragmentConferenceDetailBinding
import com.survivalcoding.ifkakao.view.main.ActivityListener
import com.survivalcoding.ifkakao.view.main.MainActivity

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

        setUpActivity()
    }

    private fun setUpActivity() {
        listener?.let {
            it.setTitle("")
            it.setButtonVisibility(View.VISIBLE)
        }
    }
}
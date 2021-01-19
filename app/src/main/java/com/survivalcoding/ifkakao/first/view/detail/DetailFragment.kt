package com.survivalcoding.ifkakao.first.view.detail

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentDetailBinding
import com.survivalcoding.ifkakao.first.model.Conference
import com.survivalcoding.ifkakao.first.view.MainActivity


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    lateinit var item: Conference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        requireActivity().title = "Conference Detail"

        arguments?.getParcelable<Conference>(MainActivity.MAIN_TO_DETAIL)?.let {
            item = it
            val dateText = "${item.start} - ${item.end}"
            binding.nameText.text = item.name
            binding.locationText.text = item.location
            binding.dateText.text = dateText
            val linkText = SpannableString(getString(R.string.hyperlink_text)).apply {
                setSpan(
                    URLSpan(item.link),
                    0,
                    getString(R.string.hyperlink_text).length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
            binding.linkText.movementMethod = LinkMovementMethod.getInstance()
            binding.linkText.text = linkText
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.jayden.ifkakaoclone.view.main.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.databinding.FragmentMenuBinding
import com.jayden.ifkakaoclone.extensions.navigateSingleTop

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false).apply {
            fragment = this@MenuFragment
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()

        with(binding) {
            textGoToSessionList.setOnClickListener { findNavController().navigateSingleTop(R.id.sessionListFragment) }
            layoutTalkChannel.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(IF_KAKAO_CHANNEL))
                startActivity(intent)
            }
            textMailAddress.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(IF_KAKAO_EMAIL))
                }
                startActivity(Intent.createChooser(intent, null))
            }
        }
    }

    companion object {
        const val IF_KAKAO_CHANNEL = "https://pf.kakao.com/_AAzxgC"
        const val IF_KAKAO_EMAIL = "ifkakao@kakao.com"
    }
}
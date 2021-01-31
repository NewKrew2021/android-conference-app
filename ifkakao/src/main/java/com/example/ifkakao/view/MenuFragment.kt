package com.example.ifkakao.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.ifkakao.R
import com.example.ifkakao.databinding.FragmentMenuBinding
import com.example.ifkakao.util.replaceTransaction

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.let {
            it.fragment = this
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.apply {
            root.setOnClickListener { } // 화면 뒤에 있는 프래그먼트에 터치 이벤트 넘어가지 않도록 처리
            sessionText.setOnClickListener {
                parentFragmentManager.popBackStack()
                parentFragmentManager.commit {
                    replace<MainFragment>(R.id.fragment_container_view)
                }
            }
            favoritesText.setOnClickListener {
                parentFragmentManager.popBackStack()
                replaceTransaction<FavoriteSessionFragment>(R.id.fragment_container_view)
            }
            talkChannelText.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(TALK_CHANNEL_URL)
                }
                ContextCompat.startActivity(binding.root.context, intent, null)
            }
            kakaoEmail.setOnClickListener {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(KAKAO_EMAIL))
                    type = "plain/text"
                }
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TALK_CHANNEL_URL = "https://pf.kakao.com/_AAzxgC"
        const val KAKAO_EMAIL = "ifkakao@kakao.com"
    }
}
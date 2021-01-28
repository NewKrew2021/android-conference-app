package com.survivalcoding.ifkakao.ifkakao.view.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMenuListBinding
import com.survivalcoding.ifkakao.ifkakao.view.main.IfKakaoFragment
import com.survivalcoding.ifkakao.ifkakao.view.sorted.FavoriteListFragment

class MenuListFragment() : Fragment() {
    private var _binding: FragmentMenuListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.menuSessionText.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<IfKakaoFragment>(R.id.if_kakao_fragment_container_view)
                addToBackStack(null)
            }
        }

        binding.menuFavoriteText.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<FavoriteListFragment>(R.id.if_kakao_fragment_container_view)
                addToBackStack(null)
            }
        }
    }
}
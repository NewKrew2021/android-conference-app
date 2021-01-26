package com.survivalcoding.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.survivalcoding.ifkakao.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {


    private var _binding: FragmentMenuBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(layoutInflater)
        val view = binding.root

        binding.sessionTextView.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MainFragment>(R.id.fragment_container_view)
            }
        }

        binding.favoritesTextView.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<FavoritesFragment>(R.id.fragment_container_view)
            }
        }
        return view
    }
}
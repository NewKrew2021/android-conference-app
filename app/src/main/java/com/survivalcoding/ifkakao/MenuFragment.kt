package com.survivalcoding.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
            if (!findNavController().popBackStack(R.id.mainFragment, false)) {
                findNavController().popBackStack(R.id.highlightFragment, false)
                findNavController().navigate(R.id.action_highlightFragment_to_mainFragment)  //popback한 다음에도 수행이 됨
            }
        }

        binding.favoritesTextView.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_favoritesFragment)
        }
        return view
    }
}
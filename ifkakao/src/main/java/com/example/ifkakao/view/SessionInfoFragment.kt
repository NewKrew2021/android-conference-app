package com.example.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ifkakao.databinding.FragmentSessionInfoBinding
import com.example.ifkakao.viewmodel.SessionViewModel

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
            it.viewModel = viewModel
            it.listButton.setOnClickListener(::moveToPreviousFragment)
            it.footer.scrollUpButton.setOnClickListener(::scrollingUp)
            it.root
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun moveToPreviousFragment(v: View) {
        parentFragmentManager.popBackStack()
    }

    private fun scrollingUp(v: View) {
        binding.contentScroll.fullScroll(View.FOCUS_UP);
    }
}
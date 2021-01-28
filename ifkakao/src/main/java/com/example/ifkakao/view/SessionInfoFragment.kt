package com.example.ifkakao.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ifkakao.R
import com.example.ifkakao.databinding.FragmentSessionInfoBinding
import com.example.ifkakao.util.makeShareLink
import com.example.ifkakao.util.showToast
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.isFavorite.observe(viewLifecycleOwner) {
            val imageResource =
                if (it) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24
            if (it) {
                binding.favoriteButton.setOnClickListener { viewModel.deleteFavoriteSession() }
            } else {
                binding.favoriteButton.setOnClickListener { viewModel.addFavoriteSession() }
            }
            binding.favoriteButton.setImageResource(imageResource)
        }

        binding.shareButton.setOnClickListener {
            viewModel.selectedSession.value?.let {
                makeShareLink(it.idx, successListener = { link ->
                    Intent(Intent.ACTION_SEND).run {
                        type = TEXT_PLAIN
                        putExtra(Intent.EXTRA_TEXT, link)
                        startActivity(Intent.createChooser(this, getString(R.string.share_session)))
                    }
                }, failureListener = {
                    showToast(getString(R.string.share_fail_message))
                }
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.removeSharedSessionIndex()
        _binding = null
    }

    private fun moveToPreviousFragment(v: View) {
        parentFragmentManager.popBackStack()
    }

    private fun scrollingUp(v: View) {
        binding.contentScroll.fullScroll(View.FOCUS_UP);
    }

    companion object {
        const val TEXT_PLAIN = "text/plain"
    }
}
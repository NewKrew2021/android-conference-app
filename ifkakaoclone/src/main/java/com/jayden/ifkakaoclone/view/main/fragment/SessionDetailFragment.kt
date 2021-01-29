package com.jayden.ifkakaoclone.view.main.fragment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.databinding.FragmentSessionDetailBinding
import com.jayden.ifkakaoclone.extensions.showToastMessage
import com.jayden.ifkakaoclone.view.main.adapter.ContentSpeakerAdapter
import com.jayden.ifkakaoclone.view.main.model.ContentsSpeakerWithLink
import com.jayden.ifkakaoclone.viewmodel.SessionViewModel

class SessionDetailFragment : Fragment() {
    private var _binding: FragmentSessionDetailBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        ContentSpeakerAdapter()
    }

    private val activityViewModel: SessionViewModel by activityViewModels()

    private val args: SessionDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSessionDetailBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@SessionDetailFragment
            viewModel = activityViewModel
            fragment = this@SessionDetailFragment
            session = args.session
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
            imageVideoShare.setOnClickListener { layoutShareItems.root.visibility = View.VISIBLE }

            with(layoutShareItems) {
                imageClose.setOnClickListener { layoutShareItems.root.visibility = View.GONE }

                imageShareKakaotalk.setOnClickListener {
                    sendIntent(PACKAGE_KAKAO_TALK)
                }

                imageShareFacebook.setOnClickListener {
                    sendIntent(PACKAGE_FACEBOOK)
                }

                imageShareCopyUrl.setOnClickListener {
                    copyVideoUrl()
                }
            }

            speakerRecyclerView.adapter = adapter

            layoutFooter.textIfkakao2019.setOnClickListener {
                openIfKakao2019()
            }

            layoutFooter.imageScrollTop.setOnClickListener {
                nestedScrollView.smoothScrollTo(0, 0)
            }
        }

        // n Configuration Change is notified again
        // so Sending Events with OneTime Only LiveData
        activityViewModel.action.observe(viewLifecycleOwner) {
            playVideoByBrowser(it.url)
        }

        activityViewModel.favorite.observe(viewLifecycleOwner) {
            activityViewModel.setSelectedFavorite(it)
        }

        updateSpeaker()
    }

    private fun playVideoByBrowser(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    private fun updateSpeaker() {
        activityViewModel.selectedItem.value?.let { session ->
            adapter.submitList(
                session.contentsSpeackerList.zip(session.linkList.speackerProfile)
                    .map { ContentsSpeakerWithLink(it.first, it.second) })
        }
    }

    private fun openIfKakao2019() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://if.kakao.com/2019"))
        startActivity(intent)
    }

    private fun sendIntent(pkgName: String) {
        activityViewModel.selectedItem.value?.let {
            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "${SESSION_VIDEO_SUFFIX}${it.idx}")
                setPackage(pkgName)
            }
            if (sendIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(sendIntent)
            }
        }

    }

    private fun copyVideoUrl() {
        activityViewModel.selectedItem.value?.let {
            val clipBoardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("VIDEO_URL", "${SESSION_VIDEO_SUFFIX}${it.idx}")
            clipBoardManager.setPrimaryClip(clip)

            showToastMessage(getString(R.string.copy_url_complete))
            binding.layoutShareItems.root.visibility = View.GONE
        }
    }

    companion object {
        const val PACKAGE_KAKAO_TALK = "com.kakao.talk"
        const val PACKAGE_FACEBOOK = "com.facebook.katana"

        const val SESSION_VIDEO_SUFFIX = "https://if.kakao.com/sessions/"
    }
}
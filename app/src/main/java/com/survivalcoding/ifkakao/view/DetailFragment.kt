package com.survivalcoding.ifkakao.view

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.facebook.share.model.ShareLinkContent
import com.facebook.share.widget.ShareDialog
import com.survivalcoding.ifkakao.databinding.FragmentDetailBinding
import com.survivalcoding.ifkakao.extension.loadUrlWithRoundCorner
import com.survivalcoding.ifkakao.model.conferenceData.ContentsSpeacker
import com.survivalcoding.ifkakao.model.conferenceData.SpeackerProfile
import com.survivalcoding.ifkakao.room.table.Favorite
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel
import com.survivalcoding.ifkakao.viewmodel.FavoriteViewModel


class DetailFragment : Fragment() {
    private var _bindng: FragmentDetailBinding? = null
    private val binding get() = _bindng!!
    val viewModel: ConferenceViewModel by activityViewModels()
    val favoriteViewModel: FavoriteViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _bindng = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detail = viewModel.selectItem.value
        binding.favoriteViewModel = favoriteViewModel
        binding.lifecycleOwner = this

        viewModel.selectItem.value?.let {
            it.linkList.speackerProfile.zip(it.contentsSpeackerList).forEach { pair ->
                makeContentSpeakerLayout(pair)
            }
            //좋아요 정보 받아오기
            favoriteViewModel.getFavoriteInfo(it.idx)
        }

        binding.apply {

            //동영상 재생 기능
            imageThumbnail.setOnClickListener {
                viewModel.selectItem.value?.linkList?.video?.let {
                    if (it.isNotEmpty()) {
                        val video = it[0]
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(video.url))
                        startActivity(intent)
                    }
                }
            }
            //좋아요 기능
            favorite.setOnClickListener {
                viewModel.selectItem.value?.idx?.let {
                    if (favoriteViewModel?.getFavorite?.value == true) {
                        favoriteViewModel?.setFavorite(Favorite(id = it, isFavorite = 0))
                    } else {
                        favoriteViewModel?.setFavorite(Favorite(id = it, isFavorite = 1))
                    }

                }
            }
            viewModel.isShareWindow.observe(viewLifecycleOwner) {
                if (it == true) {
                    binding.videoShare.visibility = View.GONE
                    binding.shareLayout.visibility = View.VISIBLE
                } else {
                    binding.videoShare.visibility = View.VISIBLE
                    binding.shareLayout.visibility = View.GONE
                }
            }

            videoShare.setOnClickListener {
                viewModel.onShareWindow()
            }

            shareClose.setOnClickListener {
                viewModel.offShareWindow()
            }
            val link = "https://if.kakao.com/session/${viewModel.selectItem.value?.idx}"

            val implicitIntent = Intent(Intent.ACTION_SEND)
            implicitIntent.setType("text/plain")
            implicitIntent.putExtra(Intent.EXTRA_TEXT, link)

            kakaoTalkShare.setOnClickListener {
                var intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")

                intent.putExtra(Intent.EXTRA_TEXT, link)
                intent.setPackage("com.kakao.talk")
                if (intent.resolveActivity(requireContext().packageManager) != null) {
                    startActivity(intent)
                } else {
                    startActivity(implicitIntent)
                }

            }

            kakaoStoryShare.setOnClickListener {
                startActivity(implicitIntent)
            }

            faceBookShare.setOnClickListener {
                ShareDialog.show(requireActivity(), ShareLinkContent.Builder().setContentUrl(Uri.parse(link)).build())
            }
            clipBoard.setOnClickListener {
                val clipBoardManager: ClipboardManager = requireActivity().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val data = ClipData.newPlainText("link", link)
                clipBoardManager.setPrimaryClip(data)
                Toast.makeText(requireContext(), "링크가 복사되었습니다.", Toast.LENGTH_SHORT).show()
            }


        }


    }

    fun makeContentSpeakerLayout(pair: Pair<SpeackerProfile, ContentsSpeacker>) {
        val linearLayout = LinearLayout(requireContext())
        val layoutHorizontalParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutHorizontalParams.bottomMargin = 16
        layoutHorizontalParams.topMargin = 32
        linearLayout.layoutParams = layoutHorizontalParams
        linearLayout.orientation = (LinearLayout.HORIZONTAL)


        //image
        val imageView = ImageView(requireContext())
        val layoutParams = LinearLayout.LayoutParams(128, 128)
        layoutParams.gravity = Gravity.CENTER
        layoutParams.marginEnd = 16
        imageView.layoutParams = layoutParams
        imageView.loadUrlWithRoundCorner(pair.first.url)
        linearLayout.addView(imageView)

        val linearLayoutContentTag = LinearLayout(requireContext())
        linearLayoutContentTag.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        linearLayoutContentTag.orientation = (LinearLayout.VERTICAL)
        //name
        val nameTextView = TextView(requireContext())
        nameTextView.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nameTextView.setTextColor(Color.WHITE)
        nameTextView.setText("${pair.second.nameKo} ${pair.second.nameEn}")
        linearLayoutContentTag.addView(nameTextView)

        //company
        val companyTextView = TextView(requireContext())
        companyTextView.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        companyTextView.setTextColor(Color.parseColor("#717171"))
        companyTextView.setText(pair.second.company)
        companyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f);
        linearLayoutContentTag.addView(companyTextView)


        //occupation
        val occupationTextView = TextView(requireContext())
        occupationTextView.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        occupationTextView.setTextColor(Color.parseColor("#717171"))
        occupationTextView.setText(pair.second.occupation)
        companyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f);
        linearLayoutContentTag.addView(occupationTextView)


        linearLayout.addView(linearLayoutContentTag)

        binding.contentSpeakerLayout.addView(linearLayout)

    }

}
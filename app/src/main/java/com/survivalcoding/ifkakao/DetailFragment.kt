package com.survivalcoding.ifkakao

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.share.model.ShareLinkContent
import com.facebook.share.widget.ShareDialog
import com.survivalcoding.ifkakao.databinding.FragmentDetailBinding
import com.survivalcoding.ifkakao.model.DetailRecyclerType
import com.survivalcoding.ifkakao.model.SpeackerInfo
import com.survivalcoding.ifkakao.model.SpecificData
import com.survivalcoding.ifkakao.view.adapter.SpeakerRecyclerAdapter
import com.survivalcoding.ifkakao.viewModel.ConferenceViewModel


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null

    val binding get() = _binding!!
    val conferenceViewModel: ConferenceViewModel by activityViewModels()
    private lateinit var adapter: SpeakerRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(layoutInflater)
        val view = binding.root

        conferenceViewModel.singleData.value?.let {

            adapter = SpeakerRecyclerAdapter(
                {

                    conferenceViewModel.singleData.value = it

                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<DetailFragment>(R.id.fragment_container_view)
                    }
                }, {
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<MainFragment>(R.id.fragment_container_view)
                    }
                }, { binding, data ->
                    if (binding.likeToggleButton.isChecked == true) conferenceViewModel.addFavoritesItem(
                        data.id
                    )
                    else conferenceViewModel.removeFavoritesItem(data.id)
                }, { binding, data ->
                    if (conferenceViewModel.isExistFavorites(data.id)) {
                        binding.likeToggleButton.isChecked = true
                    } else {
                        binding.likeToggleButton.isChecked = false
                    }
                }, { binding, data ->
                    ShareDialog.show(
                        requireActivity(), ShareLinkContent.Builder()
                            .setContentUrl(Uri.parse("https://if.kakao.com/session/" + data))
                            .build()
                    )
                }, { binding, data ->

                    try {
                        var pi =
                            requireActivity().packageManager.getPackageInfo("com.kakao.talk", 0)

                        var intent = Intent(Intent.ACTION_SEND)
                        intent.setType("text/plain")
                        var dataLink = "https://if.kakao.com/session/" + data
                        intent.putExtra(Intent.EXTRA_TEXT, dataLink)
                        intent.setPackage("com.kakao.talk")
                        startActivity(intent)

                    } catch (e: PackageManager.NameNotFoundException) {
                        Toast.makeText(requireContext(), "카카오톡 앱을 설치해야합니다", Toast.LENGTH_SHORT)
                            .show()
                    }


                }, { binding, data ->
                    val clipboardManager: ClipboardManager =
                        requireContext().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                    val clipData =
                        ClipData.newPlainText("link", "https://if.kakao.com/session/" + data)
                    clipboardManager.setPrimaryClip(clipData)

                })

            binding.speakerRecyclerView.adapter = adapter
            binding.speakerRecyclerView.layoutManager =
                LinearLayoutManager(requireContext().applicationContext)
            val contentsSpeackerList = it.contentsSpeackerList
            val speackerProfileList = it.speackerProfileList
            val detailRecyclerList = mutableListOf<DetailRecyclerType>()
            detailRecyclerList.add(it)

            if (contentsSpeackerList != null && speackerProfileList != null) {
                for (i in 0..contentsSpeackerList.size - 1) {
                    detailRecyclerList.add(
                        SpeackerInfo(
                            contentsSpeackerList[i],
                            speackerProfileList[i].url
                        )
                    )
                }
            }

            detailRecyclerList.add(SpecificData("${it.id}"))
            detailRecyclerList.add(SpecificData("listButton"))


            var relativeData = conferenceViewModel.getRelativeData(it.field, it.id)
            adapter.submitList(detailRecyclerList + relativeData)

            setWebView(it.videoUrl)

        }


        return view
    }

    fun setWebView(url: String) {
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(url)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
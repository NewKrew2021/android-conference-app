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
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.share.model.ShareLinkContent
import com.facebook.share.widget.ShareDialog
import com.survivalcoding.ifkakao.databinding.FragmentDetailBinding
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.DetailRecyclerType
import com.survivalcoding.ifkakao.model.SpeackerInfo
import com.survivalcoding.ifkakao.model.SpecificData
import com.survivalcoding.ifkakao.view.adapter.SpeakerRecyclerAdapter
import com.survivalcoding.ifkakao.viewModel.ConferenceViewModel

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null

    val binding get() = _binding!!
    private val conferenceViewModel: ConferenceViewModel by activityViewModels()
    private lateinit var adapter: SpeakerRecyclerAdapter
    private val args: DetailFragmentArgs by navArgs()

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


        adapter = SpeakerRecyclerAdapter(
            {
                val action = DetailFragmentDirections.actionDetailFragmentSelf(it)
                findNavController().navigate(action)
            }, {
                if (!findNavController().popBackStack(
                        R.id.mainFragment,
                        false
                    )
                ) findNavController().popBackStack(R.id.highlightFragment, false)
            }, { binding, data ->
                if (binding.likeToggleButton.isChecked) conferenceViewModel.addFavoritesItem(
                    data.id
                )
                else conferenceViewModel.removeFavoritesItem(data.id)
            }, { binding, data ->
                binding.likeToggleButton.isChecked = conferenceViewModel.isExistFavorites(data.id)
            }, { data ->
                ShareDialog.show(
                    requireActivity(), ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://if.kakao.com/session/$data"))
                        .build()
                )
            }, { id ->

                try {

                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    val dataLink = "https://if.kakao.com/session/$id"
                    intent.putExtra(Intent.EXTRA_TEXT, dataLink)
                    intent.setPackage("com.kakao.talk")
                    startActivity(intent)

                } catch (e: PackageManager.NameNotFoundException) {
                    Toast.makeText(requireContext(), "카카오톡 앱을 설치해야합니다", Toast.LENGTH_SHORT)
                        .show()

                    val uriBuilder = Uri.parse("https://play.google.com/store/apps/details")
                        .buildUpon()
                        .appendQueryParameter("id", "com.kakao.talk")
                        .appendQueryParameter("launch", "true")
                        .appendQueryParameter("hl", "ko")

                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = uriBuilder.build()
                        setPackage("com.android.vending")
                    }
                    startActivity(intent)
                }

            }, { data ->
                val clipboardManager: ClipboardManager =
                    requireContext().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                val clipData =
                    ClipData.newPlainText("link", "https://if.kakao.com/session/$data")
                clipboardManager.setPrimaryClip(clipData)

            })

        val singleData = args.singleData
        binding.singleData = singleData
        binding.speakerRecyclerView.adapter = adapter
        binding.speakerRecyclerView.layoutManager =
            LinearLayoutManager(requireContext().applicationContext)

        val relativeData = conferenceViewModel.getRelativeData(singleData.field, singleData.id)
        adapter.submitList(mergeAndGetSpeakerInfo(singleData) + relativeData)

        return view
    }

    private fun mergeAndGetSpeakerInfo(singleData: ConferenceAppFront): MutableList<DetailRecyclerType> {
        val contentsSpeackerList = singleData.contentsSpeackerList
        val speackerProfileList = singleData.speackerProfileList
        val detailRecyclerList = mutableListOf<DetailRecyclerType>()
        detailRecyclerList.add(singleData)

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
        detailRecyclerList.add(SpecificData("${singleData.id}"))
        detailRecyclerList.add(SpecificData("listButton"))
        return detailRecyclerList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
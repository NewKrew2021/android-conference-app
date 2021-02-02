package com.survivalcoding.ifkakao.ui.detail

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.survivalcoding.ifkakao.App
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentDetailBinding
import com.survivalcoding.ifkakao.extension.popThis
import com.survivalcoding.ifkakao.extension.showToast
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.ui.detail.adapter.SpeakerAdapter

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var item: Session? = null

    private lateinit var adapter: SpeakerAdapter

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getParcelable<Session>("picked")?.let {
            item = it.apply {
                for (i in contentsSpeakerList.indices) {
                    contentsSpeakerList[i].profileImageUrl = linkList.speakerProfile[i].url
                }
                viewModel = ViewModelProvider(
                    this@DetailFragment,
                    DetailViewModelFactory(
                        (requireActivity().application as App).likeRepository, idx
                    )
                ).get(DetailViewModel::class.java)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        adapter = SpeakerAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        binding.apply {
            lifecycleOwner = this@DetailFragment
            viewModel = this@DetailFragment.viewModel
            toolbar.title = "if(kakao)2020"
            session = item
            speakers.adapter = adapter
        }
        setUpObservers()

        item?.let {
            adapter.submitList(it.contentsSpeakerList)
        }
    }

    private fun setUpObservers() {

        viewModel.targetUrl.observe(viewLifecycleOwner) {
            requireContext().startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(it)
            })
        }

        viewModel.onBackButtonClicked.observe(viewLifecycleOwner) {
            popThis()
        }

        viewModel.onCopyButtonClicked.observe(viewLifecycleOwner) {
            copyUrlLinkToClipboard()
        }
    }

    private fun copyUrlLinkToClipboard() {
        val clipboard =
            requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        item?.let {
            val link = ClipData.newPlainText("link", it.linkList.video[0].url)
            clipboard.setPrimaryClip(link)
            showToast("클립보드에 저장되었습니다.")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_button -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
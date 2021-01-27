package com.survivalcoding.ifkakao.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentDetailBinding
import com.survivalcoding.ifkakao.extension.popThis
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.ui.detail.adapter.SpeakerAdapter
import com.survivalcoding.ifkakao.ui.main.MainActivity

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var item: Session? = null

    private lateinit var adapter: SpeakerAdapter

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getParcelable<Session>("picked")?.let {
            item = it.apply {
                for (i in contentsSpeakerList.indices) {
                    contentsSpeakerList[i].profileImageUrl = linkList.speakerProfile[i].url
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = DataBindingUtil.inflate<FragmentDetailBinding>(
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
        viewModel.targetUrl.observe(viewLifecycleOwner, Observer {
            requireContext().startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(it)
            })
        })

        viewModel.onBackButtonClicked.observe(viewLifecycleOwner, Observer {
            popThis()
        })
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
package com.survivalcoding.ifkakao.ui.favorite

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentFavoriteBinding
import com.survivalcoding.ifkakao.extension.openDetailFragment
import com.survivalcoding.ifkakao.extension.openFragmentWith
import com.survivalcoding.ifkakao.ui.info.InfoFragment
import com.survivalcoding.ifkakao.ui.main.MainActivity
import com.survivalcoding.ifkakao.ui.main.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ConferenceAdapter

    private val viewModel: ConferenceViewModel by lazy {
        (requireActivity() as MainActivity).confViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorite, container, false)

        adapter = ConferenceAdapter(
            itemClickListener = {
                openDetailFragment(it)
            }
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setUpObserver()
        setHasOptionsMenu(true)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_button -> {
                openFragmentWith<InfoFragment>()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUpObserver() {
        viewModel.favoriteSessions.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun initView() {

        binding.toolbar.apply {
            title = "Favorites"
        }

        binding.recyclerview.apply {
            adapter = this@FavoriteFragment.adapter
            addItemDecoration(
                DividerItemDecoration(
                    requireActivity(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }
}
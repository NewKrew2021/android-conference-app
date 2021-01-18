package com.survivalcoding.ifkakao.view.main.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.data.repository.Repository
import com.survivalcoding.ifkakao.data.viewmodel.ConferenceViewModel
import com.survivalcoding.ifkakao.databinding.FragmentConferenceListBinding
import com.survivalcoding.ifkakao.view.main.ActivityListener
import com.survivalcoding.ifkakao.view.main.MainActivity
import com.survivalcoding.ifkakao.view.main.adapter.ConferenceAdapter

class ConferenceListFragment(repository: Repository) : Fragment() {
    private var _binding: FragmentConferenceListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        ConferenceAdapter {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack(null)
                replace(
                    R.id.fragment_container_view,
                    ConferenceDetailFragment::class.java,
                    bundleOf(MainActivity.CONFERENCE_ITEM_KEY to it)
                )
            }
        }
    }

    private val viewModel = ConferenceViewModel(repository)

    private var listener: ActivityListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = (activity as MainActivity)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConferenceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpActivity()

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }

        updateUI()
    }

    private fun setUpActivity() {
        listener?.let {
            it.setTitle(getString(R.string.fragment_conference_list_title))
            it.setButtonVisibility(View.INVISIBLE)
        }
    }

    private fun updateUI() {
        adapter.setItems(viewModel.getItems())
        adapter.notifyDataSetChanged()
    }
}
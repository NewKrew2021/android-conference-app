package com.survivalcoding.ifkakao.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentFavoriteListBinding


class FavoriteListFragment : Fragment() {
    private var _bindng: FragmentFavoriteListBinding? = null
    private val binding get() = _bindng!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        _bindng = FragmentFavoriteListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear();
        inflater.inflate(R.menu.actionbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigationButton -> {
                parentFragmentManager.popBackStack(
                    "NavigationFragment",
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainerView, NavigationFragment())
                    addToBackStack("NavigationFragment")
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }
}
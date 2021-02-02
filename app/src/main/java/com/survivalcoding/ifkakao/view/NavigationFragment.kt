package com.survivalcoding.ifkakao.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentNavigationBinding
import com.survivalcoding.ifkakao.extension.clearBackStack


class NavigationFragment : Fragment() {
    private var _bindng: FragmentNavigationBinding? = null
    private val binding get() = _bindng!!
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        _bindng = FragmentNavigationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sessionMoveToButton.setOnClickListener {
            // backStack 다 비우
            parentFragmentManager.clearBackStack()
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragmentContainerView, ConferenceListFragment())
            }
        }
        binding.likeMoveToButton.setOnClickListener{
            //이미 있다면 다 지우기
            parentFragmentManager.popBackStack("NavigationFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            parentFragmentManager.popBackStack("FavoriteListFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerView,FavoriteListFragment())
                addToBackStack("FavoriteListFragment")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()
        activity?.invalidateOptionsMenu()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.navigation_actionbar, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitButton -> parentFragmentManager.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

}
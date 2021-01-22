package com.survivalcoding.ifkakao.extension

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.ui.detail.DetailFragment
import com.survivalcoding.ifkakao.ui.main.MainActivity.Companion.CONTAINER_VIEW_ID
import com.survivalcoding.ifkakao.ui.main.MainFragment

fun Fragment.openMainFragment() {
    parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    parentFragmentManager.commit {
        replace<MainFragment>(CONTAINER_VIEW_ID)
        setReorderingAllowed(true)
    }
}

fun Fragment.openDetailFragment(conference: Session) {

    val bundle = bundleOf("picked" to conference)

    parentFragmentManager.commit {
        replace<DetailFragment>(CONTAINER_VIEW_ID, args = bundle)
        addToBackStack(null)
        setReorderingAllowed(true)
    }
}

fun Fragment.popThis() {
    parentFragmentManager.popBackStack()
}
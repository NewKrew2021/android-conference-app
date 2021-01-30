package com.example.ifkakao.bindingadapter

import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.example.ifkakao.R

@BindingAdapter("closable_fragment")
fun Toolbar.setFilterCloseButtonClickListener(fragment: Fragment) {
    setOnMenuItemClickListener {
        when (it.itemId) {
            R.id.close_button -> {
                fragment.parentFragmentManager.popBackStack()
                true
            }
            else -> false
        }
    }
}
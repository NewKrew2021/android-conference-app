package com.example.ifkakao.bindingadapter

import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import com.example.ifkakao.R
import com.example.ifkakao.view.FilterFragment

@BindingAdapter("closable_fragment")
fun Toolbar.setFilterCloseButtonClickListener(fragment: FilterFragment) {
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
package com.survivalcoding.ifkakao.adapter

import android.util.Log
import android.view.View
import android.widget.AdapterView

class SpinnerAdapter : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("Adapter", "onItemSelected: onItemSelect + ${parent?.getItemAtPosition(position)}")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        parent?.setSelection(2)
    }

}
package com.survivalcoding.ifkakao.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.survivalcoding.ifkakao.App
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.factory.ConferenceFragmentFactory

class MainActivity : AppCompatActivity(), ActivityListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory =
            ConferenceFragmentFactory((application as App).repository)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun setTitle(text: String) {
        binding.textTitle.text = text
    }

    override fun setButtonVisibility(visibility: Int) {
        binding.btnBack.visibility = visibility
    }

    companion object {
        const val CONFERENCE_ITEM_KEY = "CONFERENCE_ITEM_KEY"
    }
}

interface ActivityListener {
    fun setTitle(text: String)
    fun setButtonVisibility(visibility: Int)
}
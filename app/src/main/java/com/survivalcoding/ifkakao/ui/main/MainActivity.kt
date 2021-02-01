package com.survivalcoding.ifkakao.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.survivalcoding.ifkakao.App
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val confViewModelFactory by lazy {
        ConferenceViewModelFactory(
            (application as App).confRepository,
            (application as App).likeRepository,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace<MainFragment>(CONTAINER_VIEW_ID)
                setReorderingAllowed(true)
            }
        }
    }

    companion object {
        const val CONTAINER_VIEW_ID = R.id.fragment_container
    }
}
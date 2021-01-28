package com.example.ifkakao.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.ifkakao.databinding.ActivityMainBinding
import com.example.ifkakao.viewmodel.SessionViewModel
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: SessionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        receiveShareLink()
    }

    private fun receiveShareLink() {
        Firebase.dynamicLinks
            .getDynamicLink(intent)
            .addOnSuccessListener(this) { pendingDynamicLinkData ->
                pendingDynamicLinkData?.let {
                    val sessionIndex = it.link?.getQueryParameter(SHARED_LINK_KEY)?.toInt() ?: 0
                    viewModel.setSharedSessionIndex(sessionIndex)
                }
            }
    }

    companion object {
        const val SHARED_LINK_KEY = "idx"
    }
}
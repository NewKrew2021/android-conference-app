package com.survivalcoding.ifkakao.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.factory.ConferenceFragmentFactory
import com.survivalcoding.ifkakao.repository.ConferenceRepository


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val repository = ConferenceRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = ConferenceFragmentFactory(repository)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragmentContainerView, ConferenceListFragment())
            }
        }
    }

}
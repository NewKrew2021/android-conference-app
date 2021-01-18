package com.survivalcoding.ifkakao.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.factory.ConferenceFragmentFactory
import com.survivalcoding.ifkakao.repository.ConferenceRepository

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val repository = ConferenceRepository()
        supportFragmentManager.fragmentFactory = ConferenceFragmentFactory(repository)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(savedInstanceState == null){
            supportFragmentManager.commit{
                setReorderingAllowed(true)
                add(R.id.fragmentContainerView, ListFragment(repository))
            }
        }
    }
}
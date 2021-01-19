package com.jayden.ifkakaoclone.view.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.jayden.ifkakaoclone.App
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.databinding.ActivityMainBinding
import com.jayden.ifkakaoclone.factory.SessionFragmentFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory =
            SessionFragmentFactory((application as App).repository)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }
}
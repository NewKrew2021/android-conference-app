package com.jayden.ifkakaoclone.view.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.jayden.ifkakaoclone.App
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.data.Repository
import com.jayden.ifkakaoclone.databinding.ActivityMainBinding
import com.jayden.ifkakaoclone.extensions.navigateSingleTop
import com.jayden.ifkakaoclone.viewmodel.SessionViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: SessionViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(Repository::class.java).newInstance(
                    (application as App).repository
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_nav -> {
                findNavController(R.id.fragment_container_view).navigateSingleTop(R.id.menuFragment)    // 동일한 프래그먼트 쌓이는 것을 방지하기 위해
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
package com.survivalcoding.ifkakao.second.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: SecondActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setSupportActionBar(binding.toolbar)
        setContentView(view)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_nav -> {
                findNavController(R.id.fragment_container_view).navigate(
                    R.id.menuFragment,
                    null,
                    NavOptions.Builder().apply {
                        setLaunchSingleTop(true)
                    }.build()
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
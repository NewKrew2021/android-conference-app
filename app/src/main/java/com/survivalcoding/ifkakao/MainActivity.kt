package com.survivalcoding.ifkakao

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.factory.MyFragmentFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportFragmentManager.fragmentFactory =
            MyFragmentFactory()


        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""

        setSupportActionBar(binding.toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        binding.textView.setOnClickListener {

            navController.popBackStack(R.id.highlightFragment, false)
        }

        binding.button.setOnClickListener {

            val currentFragment =
                findNavController(R.id.fragment_container_view).currentDestination?.id
            if (findNavController(R.id.fragment_container_view).popBackStack(
                    R.id.menuFragment,
                    false
                )
            )
            else if (currentFragment != R.id.menuFragment) navController.navigate(R.id.menuFragment)
        }

        val serviceIntent = Intent(this, MyService::class.java)
        serviceIntent.putExtra("noahName", "jinhong")
        startService(serviceIntent)


    }
}
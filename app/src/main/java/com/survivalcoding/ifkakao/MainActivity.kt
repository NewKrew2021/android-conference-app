package com.survivalcoding.ifkakao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
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

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HighlightFragment>(R.id.fragment_container_view)
            }
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("")

        setSupportActionBar(binding.toolbar)
        binding.textView.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<HighlightFragment>(R.id.fragment_container_view)
            }
        }

        binding.button.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MenuFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }
    }

}
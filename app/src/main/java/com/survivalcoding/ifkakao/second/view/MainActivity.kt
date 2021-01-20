package com.survivalcoding.ifkakao.second.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondActivityMainBinding
import com.survivalcoding.ifkakao.second.factory.ContentFragmentFactory
import com.survivalcoding.ifkakao.second.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: SecondActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = ContentFragmentFactory()
        super.onCreate(savedInstanceState)
        binding = SecondActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragment_container_view)
            }
        }
    }
}
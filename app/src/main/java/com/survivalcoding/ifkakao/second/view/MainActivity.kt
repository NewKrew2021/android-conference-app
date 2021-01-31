package com.survivalcoding.ifkakao.second.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.survivalcoding.ifkakao.databinding.SecondActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: SecondActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
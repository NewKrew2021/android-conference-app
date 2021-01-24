package com.survivalcoding.ifkakao.first.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FirstActivityMainBinding
import com.survivalcoding.ifkakao.first.factory.ConferenceFragmentFactory
import com.survivalcoding.ifkakao.first.view.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: FirstActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = ConferenceFragmentFactory()
        super.onCreate(savedInstanceState)
        binding = FirstActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragment_container_view)
            }
        }
    }

    companion object {
        const val MAIN_TO_DETAIL = "main_to_detail"
    }
}
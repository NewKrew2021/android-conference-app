package com.survivalcoding.ifkakao.second.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondActivityMainBinding
import com.survivalcoding.ifkakao.second.App
import com.survivalcoding.ifkakao.second.factory.ContentFragmentFactory
import com.survivalcoding.ifkakao.second.model.repository.Repository
import com.survivalcoding.ifkakao.second.view.main.MainFragment
import com.survivalcoding.ifkakao.second.viewmodel.ContentViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: SecondActivityMainBinding
    private val viewModel: ContentViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return modelClass.getConstructor(Repository::class.java).newInstance(
                    (application as App).repository
                )
            }
        }
    }

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
        viewModel
    }
}
package com.survivalcoding.ifkakao.ui.view

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.ui.base.BaseActivity
import com.survivalcoding.ifkakao.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {
        setSupportActionBar(findViewById(R.id.toolbar_main))
        setInstanceState()
        eventProcess()
    }

    override fun getViewModelData() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun startObserveData() {
        //
    }

    private fun setInstanceState() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<MainFragment>(R.id.fragment_container_view, "main")
        }
    }

    private fun eventProcess() {
        binding.tvTitleMain.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MainFragment>(R.id.fragment_container_view)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_item_main -> {
                startActivity(Intent(this, SessionEventMenuActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

}
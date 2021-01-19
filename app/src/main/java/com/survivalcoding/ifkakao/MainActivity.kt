package com.survivalcoding.ifkakao

import android.content.ContentValues
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.factory.MyFragmentFactory
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import com.survivalcoding.ifkakao.view.adapter.RecyclerAdapter
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter
    var finishDownload: String by Delegates.observable("initValue") { props, old, new ->


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportFragmentManager.fragmentFactory =
            MyFragmentFactory()

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragment_container_view)
            }
        }
    }


}
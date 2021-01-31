package com.survivalcoding.ifkakao.ifkakao.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.ifkakao.view.menu.MenuListFragment

class IfKakaoActivity : AppCompatActivity(R.layout.activity_if_kakao) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_appbar_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_icon -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<MenuListFragment>(R.id.if_kakao_fragment_container_view)
                    addToBackStack(null)
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
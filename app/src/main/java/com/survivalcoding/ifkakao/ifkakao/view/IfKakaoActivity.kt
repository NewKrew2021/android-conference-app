package com.survivalcoding.ifkakao.ifkakao.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.ifkakao.view.main.IfKakaoFragment

class IfKakaoActivity : AppCompatActivity(R.layout.activity_if_kakao) {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = IfKakaoFactory()
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<IfKakaoFragment>(R.id.if_kakao_fragment_container_view)
            }
        }
    }
}
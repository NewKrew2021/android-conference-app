package com.survivalcoding.ifkakao.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.survivalcoding.ifkakao.R

class SessionEventMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_session_event_menu)

        findViewById<ImageView>(R.id.iv_close_session_event_menu).setOnClickListener {
            finish()
        }
    }
}
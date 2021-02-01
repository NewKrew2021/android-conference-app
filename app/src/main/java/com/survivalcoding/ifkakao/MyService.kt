package com.survivalcoding.ifkakao

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService : Service() {

    override fun onCreate() {
        Log.d("log2", "서비스 최초 생성")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()


        Log.d("log2", "서비스 재실행")

        val noahName = intent.getStringExtra("noahName")
        Toast.makeText(this, "noahName is ${noahName}", Toast.LENGTH_SHORT).show()

        stopSelf()  //destroy기 그냥 확인해보기

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        Toast.makeText(this, "서비스 종료", Toast.LENGTH_SHORT).show()
        Log.d("log2", "서비스 종료")
    }
}



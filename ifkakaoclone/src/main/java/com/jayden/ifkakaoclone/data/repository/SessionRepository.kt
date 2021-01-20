package com.jayden.ifkakaoclone.data.repository

import android.content.Context
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.view.main.model.Session
import com.jayden.ifkakaoclone.view.main.model.SessionResult
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.io.ByteArrayOutputStream
import java.io.IOException

class SessionRepository(private val context: Context) : Repository {
    private val dummyData = generateDataFromFile()
    private val moshi = Moshi.Builder().build()

    override fun getSessions(): List<Session> {
        val adapter: JsonAdapter<SessionResult> = moshi.adapter(SessionResult::class.java)
        val sessionResult = adapter.fromJson(dummyData)

        return sessionResult?.data ?: listOf()
    }

    private fun generateDataFromFile(): String {
        val inputStream = context.resources.openRawResource(R.raw.dummy_data)
        val outputStream = ByteArrayOutputStream()
        var result: String? = null

        try {
            var i = inputStream.read()
            while (i != -1) {
                outputStream.write(i)
                i = inputStream.read()
            }
            result = String(outputStream.toByteArray(), Charsets.UTF_8)
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return result ?: ""
    }
}
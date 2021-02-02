package com.jayden.ifkakaoclone.view.file

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jayden.ifkakaoclone.databinding.ActivityTestFileAccessBinding
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

private const val FILE_CONTENT = "Hello World!"

class TestFileAccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestFileAccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestFileAccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnCreateFile.setOnClickListener {
                createTxtFileIfFilenameNotBlank()
            }
            btnCreateCacheFile.setOnClickListener {
                createCacheTxtFileIfFilenameNotBlank()
            }
            btnShowAllFilesPath.setOnClickListener {
                showAllFilesPath()
            }
        }
    }

    private fun appendLogInTextView(log: String) {
        binding.textLog.appendln(log)
    }

    /**
     * Internal Storage 는 권한이 필요 없다.
     * External Storage 는 API >= 19 부터 권한이 필요 없다.
     *
     * App 의 Internal Storage 에 파일 생성
     * (path: data -> data -> package name -> files)
     */
    private fun createTxtFileIfFilenameNotBlank() {
        val filename = binding.editTextFileName.text.toString()

        // API >= 24부터 Context.MODE_PRIVATE 으로 openFileOutput()을 사용하지 않을 경우,
        // SecurityException 이 발생
        if (filename.isNotBlank()) {
            openFileOutput(filename, Context.MODE_PRIVATE).use {
                it.write(FILE_CONTENT.toByteArray())
            }
            appendLogInTextView("$filename is created.")
        } else {
            appendLogInTextView("Filename is Blank.")
        }
    }

    /**
     * App의 Internal Cache 에 파일 생성
     * (path: data -> data -> package name -> cache)
     */
    private fun createCacheTxtFileIfFilenameNotBlank() {
        val filename = binding.editTextFileName.text.toString()

        if (filename.isNotBlank()) {
            val file = File.createTempFile(filename, ".txt", cacheDir)
            BufferedWriter(FileWriter(file, true)).use {
                it.write(FILE_CONTENT)
            }

            appendLogInTextView("$filename is created.")
        } else {
            appendLogInTextView("Filename is Blank.")
        }
    }

    private fun showAllFilesPath() {
        fileList().forEachIndexed { index, filename ->
            appendLogInTextView("Internal Storage Persistent ${index + 1}: $filename")
        }
        cacheDir.listFiles()?.forEachIndexed { index, file ->
            appendLogInTextView("Internal Cache ${index + 1}: ${file.name}")
        }
    }
}

fun TextView.appendln(str: String) = append("$str\n")
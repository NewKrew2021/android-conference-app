package com.jayden.ifkakaoclone.view.provider

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.jayden.ifkakaoclone.databinding.ActivityProviderTestBinding
import com.jayden.ifkakaoclone.view.file.appendln

class ProviderTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProviderTestBinding

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                getImageFiles()
            } else {
                Log.d(javaClass.simpleName, "권한을 거부했으니 이 기능을 사용할 수 없습니다.")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProviderTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnShowAllFiles.setOnClickListener {
                if (isPermissionGranted()) {
                    getImageFiles()
                }
            }
        }
    }

    private fun appendLog(text: String) = binding.textLog.appendln(text)

    private fun isPermissionGranted(): Boolean {
        return when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED -> {
                true
            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) -> {
                showPermissionRequestExplanation(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    "무슨 기능 때문에 저장 공간 읽기 권한이 필요합니다."
                ) { requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE) }
                false
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                false
            }
        }
    }

    private fun showPermissionRequestExplanation(
        permission: String,
        message: String,
        retry: (() -> Unit)? = null
    ) {
        Log.d(javaClass.simpleName, "showPermissionRequestExplanation()")

        AlertDialog.Builder(this).apply {
            setTitle("$permission 이 필요합니다.")
            setMessage(message)
            setPositiveButton("Ok") { _, _ -> retry?.invoke() }
            setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
        }.show()
    }

    private fun getImageFiles() {
        contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null,
            null,
            null,
            null
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndex(MediaStore.Images.Media._ID)
            val nameColumn = cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)
            appendLog("이미지 앱 Authority : ${MediaStore.Images.Media.EXTERNAL_CONTENT_URI}")
            appendLog("이미지 개수 : ${cursor.count}")

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val name = cursor.getString(nameColumn)
                val contentUri = Uri.withAppendedPath(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    id.toString()
                )

                appendLog(name)
                createImageView(contentUri)
            }
        }
    }

    private fun createImageView(contentUri: Uri) {
        val imageView = ImageView(this).apply {
            setImageURI(contentUri)
        }
        binding.layoutImages.addView(imageView)
    }
}
package com.jayden.ifkakaoclone.view.permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jayden.ifkakaoclone.R

/**
 * checkRuntimePermission()
 *      -> 퍼미션 요청 다이얼로그 -> 1. 승인 -> requestPermissionLauncher isGranted. -> fakeFunctionWithCamera()
 *
 *                          -> 2. 거부 -> 권한을 거부했으니 사용 불가능 안내 -> 두번째 실행 -> shouldShowRequestPermissionRationale() = true
 *                              -> showPermissionRequestExplanation() -> onPositiveButton Clicked() -> 퍼미션 요청 다이얼로그
 *
 *  shouldShowRequestPermissionRationale()에서 거부하면 퍼미션 요청 다이얼로그를 더 이상 띄우지 않음
 */
class PermissionActivity : AppCompatActivity() {
    // handle the permission response
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Log.d(javaClass.simpleName, "requestPermissionLauncher isGranted.")
                fakeFunctionWithCamera()
            } else {
                // 사용자에게 권한을 너가 거부했으니 이 기능을 사용할 수 없다고 이 시점에 안내
                // 동시에 사용자에 선택을 존중해라. 사용자의 편의를 위해 시스템 설정으로 자동으로 가게 해주지는 말아라.
                Log.d(javaClass.simpleName, "권한을 거부했으니 이 기능을 사용할 수 없습니다.")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        checkRuntimePermission()
    }

    private fun checkRuntimePermission() {
        // shouldShowRequestPermissionRationale 에 대한 분기
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED -> {
                    Log.d(javaClass.simpleName, "사용자가 권한을 바로 동의하였습니다.")
                    fakeFunctionWithCamera()
                }
                // Deny 할 시 다음 실행부터 이 곳으로 분기된다.
                shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                    // 왜 이 권한이 필요한지 설명하고, "취소"나 "괜찮습니다" 같은 버튼을 포함해서 사용자가 권한 승인 없이 앱을 사용하도록 해야 하는 곳
                    showPermissionRequestExplanation(
                        Manifest.permission.CAMERA,
                        "무슨 기능 때문에 카메라 권한이 필요합니다."
                    ) { requestPermissionLauncher.launch(Manifest.permission.CAMERA) }
                }
                else -> {
                    // ActivityRequestLauncher.launch() 시 해당 권한 승인 dialog 가 보여진다.
                    requestPermissionLauncher.launch(Manifest.permission.CAMERA)
                }
            }
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
                Log.d(javaClass.simpleName, "사용자가 권한을 바로 동의하였습니다.")
                fakeFunctionWithCamera()
            } else {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
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

    // 카메라 권한이 있을 때에만 수행하는 가짜 함수
    private fun fakeFunctionWithCamera() {
        Log.d(javaClass.simpleName, "fakeFunctionWithCamera()")
    }
}
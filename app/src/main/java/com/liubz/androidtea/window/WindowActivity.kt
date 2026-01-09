package com.liubz.androidtea.window

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.liubz.androidtea.R

class WindowActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE_OVERLAY_PERMISSION = 1001
        private const val REQUEST_CODE_MANAGE_OVERLAY_PERMISSION = 1002
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)

        // 检查并请求悬浮窗权限
        checkOverlayPermission()
    }

    /**
     * 检查悬浮窗权限
     */
    private fun checkOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                showPermissionDialog()
            } else {
                // 已有权限，启动悬浮窗服务
                startFloatingService()
            }
        } else {
            // Android 6.0以下不需要动态申请
            startFloatingService()
        }
    }

    /**
     * 显示权限申请对话框
     */
    private fun showPermissionDialog() {
        AlertDialog.Builder(this)
            .setTitle("需要悬浮窗权限")
            .setMessage("此功能需要悬浮窗权限，请前往设置开启")
            .setPositiveButton("去设置") { _, _ ->
                requestOverlayPermission()
            }
            .setNegativeButton("取消") { _, _ ->
                Toast.makeText(this, "需要权限才能使用悬浮窗", Toast.LENGTH_SHORT).show()
                finish()
            }
            .setCancelable(false)
            .show()
    }

    /**
     * 请求悬浮窗权限
     */
    private fun requestOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Android 6.0 - 10
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
                )
                startActivityForResult(intent, REQUEST_CODE_OVERLAY_PERMISSION)
            } else {
                // Android 10+ 需要使用特定的ACTION_MANAGE_OVERLAY_PERMISSION
                val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                intent.data = Uri.parse("package:$packageName")
                startActivityForResult(intent, REQUEST_CODE_MANAGE_OVERLAY_PERMISSION)
            }
        }
    }

    /**
     * 启动悬浮窗服务
     */
    private fun startFloatingService() {
        val serviceIntent = Intent(this, FloatingWindowService::class.java)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Android 8.0+ 需要启动前台服务
            startForegroundService(serviceIntent)
        } else {
            startService(serviceIntent)
        }

        Toast.makeText(this, "悬浮窗已启动", Toast.LENGTH_SHORT).show()
        finish() // 关闭Activity，悬浮窗会在后台运行
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            REQUEST_CODE_OVERLAY_PERMISSION, REQUEST_CODE_MANAGE_OVERLAY_PERMISSION -> {
                // 检查权限是否已授予
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (Settings.canDrawOverlays(this)) {
                        startFloatingService()
                    } else {
                        Toast.makeText(this, "权限被拒绝，无法使用悬浮窗", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // 注意：这里我们不停止服务，因为悬浮窗需要在后台持续运行
    }
}
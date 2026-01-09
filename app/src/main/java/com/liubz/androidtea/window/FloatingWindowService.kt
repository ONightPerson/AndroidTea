package com.liubz.androidtea.window

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.util.DisplayMetrics
import android.view.*
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.liubz.androidtea.R

class FloatingWindowService : Service() {

    private lateinit var windowManager: WindowManager
    private lateinit var floatingView: View
    private lateinit var layoutParams: WindowManager.LayoutParams

    // 用于计算拖拽的变量
    private var initialX = 0
    private var initialY = 0
    private var initialTouchX = 0f
    private var initialTouchY = 0f

    // 窗口是否在左侧
    private var isLeftSide = true

    override fun onCreate() {
        super.onCreate()
        // 创建前台通知（Android 8.0+ 必须）
        createNotificationChannel()
        startForeground(1, createNotification())

        // 初始化WindowManager
        windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

        // 创建悬浮窗View
        setupFloatingView()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    @SuppressLint("ClickableViewAccessibility")
    private fun setupFloatingView() {
        // 创建窗口布局参数
        layoutParams = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,  // Android 8.0+
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,  // 不获取焦点，不影响其他应用
                PixelFormat.TRANSLUCENT
            )
        } else {
            @Suppress("DEPRECATION")
            WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,  // Android 8.0以下
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
            )
        }

        // 设置初始位置（左上角）
        layoutParams.gravity = Gravity.START or Gravity.TOP
        layoutParams.x = 100
        layoutParams.y = 100

        // 加载布局
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        floatingView = inflater.inflate(R.layout.floating_window, null)

        // 获取布局中的组件
        val container = floatingView.findViewById<LinearLayout>(R.id.floating_container)
        val textView = floatingView.findViewById<TextView>(R.id.floating_text)
        val button = floatingView.findViewById<Button>(R.id.floating_button)
        val closeButton = floatingView.findViewById<Button>(R.id.close_button)

        // 设置TextView文本
        textView.text = "可拖拽悬浮窗\nX: ${layoutParams.x}, Y: ${layoutParams.y}"

        // 设置按钮点击事件
        button.setOnClickListener {
            Toast.makeText(this, "悬浮窗按钮被点击!", Toast.LENGTH_SHORT).show()
            textView.text = "按钮已点击\nX: ${layoutParams.x}, Y: ${layoutParams.y}"
        }

        // 关闭按钮
        closeButton.setOnClickListener {
            stopSelf()
        }

        // 设置拖拽触摸事件
        container.setOnTouchListener(object : OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        // 记录初始位置
                        initialX = layoutParams.x
                        initialY = layoutParams.y
                        initialTouchX = event.rawX
                        initialTouchY = event.rawY
                        return true
                    }

                    MotionEvent.ACTION_MOVE -> {
                        // 计算移动距离并更新窗口位置
                        layoutParams.x = initialX + (event.rawX - initialTouchX).toInt()
                        layoutParams.y = initialY + (event.rawY - initialTouchY).toInt()

                        // 限制窗口不超出屏幕
                        limitWindowPosition()

                        // 更新窗口位置
                        windowManager.updateViewLayout(floatingView, layoutParams)

                        // 更新TextView显示位置信息
                        textView.text = "正在拖拽...\nX: ${layoutParams.x}, Y: ${layoutParams.y}"
                        return true
                    }

                    MotionEvent.ACTION_UP -> {
                        // 拖拽结束，吸附到最近的屏幕边缘
                        snapToEdge()
                        textView.text = "拖拽结束\nX: ${layoutParams.x}, Y: ${layoutParams.y}"
                        return true
                    }
                }
                return false
            }
        })

        // 添加窗口到WindowManager
        try {
            windowManager.addView(floatingView, layoutParams)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 限制窗口不超出屏幕边界
     */
    private fun limitWindowPosition() {
        val display = windowManager.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)

        val screenWidth = metrics.widthPixels
        val screenHeight = metrics.heightPixels

        // 限制X坐标
        layoutParams.x = layoutParams.x.coerceIn(0, screenWidth - floatingView.width)

        // 限制Y坐标（考虑状态栏高度）
        val statusBarHeight = getStatusBarHeight()
        layoutParams.y = layoutParams.y.coerceIn(
            statusBarHeight,
            screenHeight - floatingView.height - getNavigationBarHeight()
        )
    }

    /**
     * 拖拽结束后吸附到最近的屏幕边缘
     */
    private fun snapToEdge() {
        val display = windowManager.defaultDisplay
        val metrics = DisplayMetrics()
        display.getMetrics(metrics)

        val screenWidth = metrics.widthPixels
        val screenCenterX = screenWidth / 2

        if (layoutParams.x + floatingView.width / 2 < screenCenterX) {
            // 吸附到左侧
            layoutParams.x = 0
            isLeftSide = true
        } else {
            // 吸附到右侧
            layoutParams.x = screenWidth - floatingView.width
            isLeftSide = false
        }

        windowManager.updateViewLayout(floatingView, layoutParams)
    }

    /**
     * 获取状态栏高度
     */
    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    /**
     * 获取导航栏高度
     */
    private fun getNavigationBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    /**
     * 创建通知渠道（Android 8.0+）
     */
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "floating_window_channel",
                "悬浮窗服务",
                NotificationManager.IMPORTANCE_LOW
            )
            channel.description = "悬浮窗服务正在运行"
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    /**
     * 创建前台通知
     */
    private fun createNotification(): Notification {
        return NotificationCompat.Builder(this, "floating_window_channel")
            .setContentTitle("悬浮窗服务")
            .setContentText("悬浮窗正在运行")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }

    override fun onDestroy() {
        super.onDestroy()
        // 移除悬浮窗
        if (::floatingView.isInitialized) {
            windowManager.removeView(floatingView)
        }
    }
}
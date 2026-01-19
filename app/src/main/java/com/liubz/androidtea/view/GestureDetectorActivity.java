package com.liubz.androidtea.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityGestureDetectorBinding;

/**
 * @Desc: GestureDetector 应用场景演示：识别复杂手势组合
 * @Author: liubaozhu
 */
public class GestureDetectorActivity extends AppCompatActivity implements 
        GestureDetector.OnGestureListener, 
        GestureDetector.OnDoubleTapListener {

    private static final String TAG = "GestureDetectorAct";
    private ActivityGestureDetectorBinding binding;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGestureDetectorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("GestureDetector 手势实验室");

        // 1. 初始化 GestureDetector
        mGestureDetector = new GestureDetector(this, this);
        // 解决长按后无法拖动的问题
        mGestureDetector.setIsLongpressEnabled(true);
        // 设置双击监听
        mGestureDetector.setOnDoubleTapListener(this);

        initListeners();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initListeners() {
        // 2. 接管目标 View 的 Touch 事件
        binding.gestureTestArea.setOnTouchListener((v, event) -> {
            // 将所有触摸事件交给 GestureDetector 处理
            return mGestureDetector.onTouchEvent(event);
        });
    }

    private void updateLog(String log) {
        Log.d(TAG, log);
        binding.tvGestureLog.setText(log);
    }

    // --- OnGestureListener 回调 ---

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        updateLog("onDown: 按下");
        return true; // 必须返回 true，否则后续事件无法接收
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {
        updateLog("onShowPress: 稍长按住（未松手）");
    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        updateLog("onSingleTapUp: 单击抬起");
        return true;
    }

    @Override
    public boolean onScroll(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float deltaY) {
        updateLog(String.format("onScroll: 滑动中 (dx:%.1f, dy:%.1f)", distanceX, deltaY));
        // 演示：跟随手指移动
        binding.tvTarget.setTranslationX(binding.tvTarget.getTranslationX() - distanceX);
        binding.tvTarget.setTranslationY(binding.tvTarget.getTranslationY() - deltaY);
        return true;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {
        updateLog("onLongPress: 长按触发！");
        binding.tvTarget.setBackgroundColor(0xFFE91E63); // 变色
        Toast.makeText(this, "长按触发了功能菜单", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        updateLog(String.format("onFling: 抛掷! (vx:%.1f, vy:%.1f)", velocityX, velocityY));
        return true;
    }

    // --- OnDoubleTapListener 回调 ---

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
        updateLog("onSingleTapConfirmed: 严格的单击确认");
        return true;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent e) {
        updateLog("onDoubleTap: 双击点赞！");
        binding.tvTarget.animate().scaleX(1.5f).scaleY(1.5f).setDuration(100).withEndAction(() -> {
            binding.tvTarget.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
        }).start();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
        // 双击期间产生的其他事件（如移动）
        return true;
    }
}

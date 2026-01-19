package com.liubz.androidtea.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityVelocityTrackerBinding;

public class VelocityTrackerActivity extends AppCompatActivity {
    private static final String TAG = "VelocityTrackerActivity";
    private ActivityVelocityTrackerBinding binding;
    private VelocityTracker mVelocityTracker;
    private int mMaxVelocity;
    private float mInitialX;
    private float mInitialTouchX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVelocityTrackerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("VelocityTracker 速度追踪");

        mMaxVelocity = ViewConfiguration.get(this).getScaledMaximumFlingVelocity();

        initListeners();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initListeners() {
        binding.cvSwipeCard.setOnTouchListener((v, event) -> {
            initVelocityTrackerIfNotExists();
            mVelocityTracker.addMovement(event);

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    v.animate().cancel();
                    // 记录按下时的初始位置和手指位置
                    mInitialX = v.getTranslationX();
                    mInitialTouchX = event.getRawX();
                    return true;
                case MotionEvent.ACTION_MOVE:
                    // 计算移动的增量，并应用到卡片上，实现平滑跟随
                    float deltaX = event.getRawX() - mInitialTouchX;
                    v.setTranslationX(mInitialX + deltaX);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    mVelocityTracker.computeCurrentVelocity(1000, mMaxVelocity);
                    float xVelocity = mVelocityTracker.getXVelocity();
                    
                    String info = String.format("当前水平速度: %.2f px/s", xVelocity);
                    binding.tvVelocityInfo.setText(info);
                    Log.i(TAG, "initListeners: " + info);
                    if (Math.abs(xVelocity) > 2000) {
                        Toast.makeText(this, "惯性极大！卡片飞出！", Toast.LENGTH_SHORT).show();
                        v.animate()
                                .translationX(xVelocity > 0 ? 2000 : -2000)
                                .alpha(0)
                                .setDuration(200)
                                .withEndAction(() -> {
                                    v.setTranslationX(0);
                                    v.setAlpha(1);
                                    binding.tvVelocityInfo.setText("速度: 0 (已复位)");
                                })
                                .start();
                    } else {
                        v.animate().translationX(0).setDuration(200).start();
                    }
                    recycleVelocityTracker();
                    break;
            }
            return false;
        });
    }

    private void initVelocityTrackerIfNotExists() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }
}

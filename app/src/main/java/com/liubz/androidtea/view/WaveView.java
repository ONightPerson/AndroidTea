package com.liubz.androidtea.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @Desc: 自定义波纹滚动 View (正弦曲线实现)
 * @Author: liubaozhu
 */
public class WaveView extends View {

    private Paint mPaint;
    private Path mPath;

    private int mWidth;
    private int mHeight;

    private float mWaveAmplitude = 30f; // 振幅 (波的高度)
    private float mWaveLength;          // 波长
    private float mOffset = 0f;         // 偏移量 (实现滚动)

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(0xFF2196F3);
        mPaint.setStyle(Paint.Style.FILL);
        
        mPath = new Path();

        // 开启无限循环动画
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(animation -> {
            mOffset = (float) animation.getAnimatedValue();
            postInvalidate();
        });
        animator.start();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int h1) {
        super.onSizeChanged(w, h, oldw, h1);
        mWidth = w;
        mHeight = h;
        mWaveLength = w; // 设置一个周期为一个屏幕宽
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        drawWave(canvas, mOffset, 0.5f); // 第一层波纹
        drawWave(canvas, mOffset + 0.5f, 0.3f); // 第二层波纹 (相位偏移，透明度降低)
    }

    private void drawWave(Canvas canvas, float offsetPercent, float alpha) {
        mPath.reset();
        mPaint.setAlpha((int) (255 * alpha));

        float startY = mHeight / 2f;
        mPath.moveTo(-mWidth, startY);

        // 绘制两个周期的正弦曲线，保证滚动衔接
        for (float x = -mWidth; x <= mWidth; x += 1) {
            float y = (float) (mWaveAmplitude * Math.sin(2 * Math.PI / mWaveLength * (x + offsetPercent * mWidth)) + startY);
            mPath.lineTo(x, y);
        }

        // 封闭路径用于填充颜色
        mPath.lineTo(mWidth, mHeight);
        mPath.lineTo(-mWidth, mHeight);
        mPath.close();

        canvas.drawPath(mPath, mPaint);
    }
}

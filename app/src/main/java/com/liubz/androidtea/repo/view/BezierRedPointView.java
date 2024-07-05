package com.liubz.androidtea.repo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 7/5/24 5:09 PM
 */
public class BezierRedPointView extends View {
    private Paint paint;
    private float[] currentPosition = new float[2];
    private boolean isAnimating = false;

    public BezierRedPointView(Context context) {
        super(context);
        init();
    }

    public BezierRedPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    public void startAnimation(PointF startPoint, PointF endPoint, PointF controlPoint) {
        isAnimating = true;
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(300); // 动画持续时间
        animator.setInterpolator(new AccelerateInterpolator(2));
        animator.addUpdateListener(animation -> {
            float t = (float) animation.getAnimatedValue();
            currentPosition[0] = calculateBezierPoint(t, startPoint.x, controlPoint.x, endPoint.x);
            currentPosition[1] = calculateBezierPoint(t, startPoint.y, controlPoint.y, endPoint.y);
            if (t == 1) {
                isAnimating = false;
            }
            invalidate(); // 重绘视图
        });
        animator.start();
    }

    private float calculateBezierPoint(float t, float p0, float p1, float p2) {
        return (1 - t) * (1 - t) * p0 + 2 * (1 - t) * t * p1 + t * t * p2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isAnimating) {
            canvas.drawCircle(currentPosition[0], currentPosition[1], 12, paint);
        } else {
            canvas.drawARGB(0, 0, 0, 0);
        }
    }
}


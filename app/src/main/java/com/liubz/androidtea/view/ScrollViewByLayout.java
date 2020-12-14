package com.liubz.androidtea.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/**
 * Created by liubaozhu on 2020/12/11
 */
public class ScrollViewByLayout extends View {
    private static final String TAG = "ScrollViewByLayout";

    private static final int MIN_SCROLL_DISTANCE = 20;
    private static final long MIN_TOUCH_TIME = 200L;

    private float mLastX;
    private float mLastY;
    private long mLastTchTime;

    public ScrollViewByLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0, 0);
    }

    public ScrollViewByLayout(Context context,
                              @Nullable AttributeSet attrs,
                              int defStyleAttr,
                              int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean performClick() {
        Log.i(TAG, "performClick: ");
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent: event: " + event);
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                mLastTchTime = System.currentTimeMillis();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = (int) (x - mLastX);
                int offsetY = (int) (y - mLastY);
                // 方式 1
                //                layout(getLeft() + offsetX, getTop() + offsetY,
                //                        getRight() + offsetX, getBottom() + offsetY);
                // 方式 2
                //                offsetLeftAndRight(offsetX);
                //                offsetTopAndBottom(offsetY);
                // 方式 3
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
                params.leftMargin += + offsetX;
                params.topMargin  += offsetY;
                setLayoutParams(params);
                break;
            case MotionEvent.ACTION_UP:
                long touchInterval = System.currentTimeMillis() - mLastTchTime;
                float totalOffsetX =  Math.abs(x - mLastX);
                float totalOffsetY = Math.abs(y - mLastY);
                Log.i(TAG,
                        "onTouchEvent: touchTime: " + touchInterval + ", offset: ("
                                + totalOffsetX + ", " + totalOffsetY + ").");
                if (touchInterval > MIN_TOUCH_TIME && totalOffsetX > MIN_SCROLL_DISTANCE
                        || totalOffsetY > MIN_SCROLL_DISTANCE) {
                    return true;
                } else {
                    performClick();
                    Log.i(TAG, "onTouchEvent: event: " + event);
                }
                break;
            default:
                break;
        }
        return false;
    }
}

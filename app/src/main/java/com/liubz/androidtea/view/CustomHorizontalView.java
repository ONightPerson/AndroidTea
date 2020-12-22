package com.liubz.androidtea.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liubaozhu on 2020/12/20
 */
public class CustomHorizontalView extends ViewGroup {

    private int mLastInterceptX;
    private int mLastInterceptY;
    private int mLastX;
    private int mLastY;

    public CustomHorizontalView(Context context) {
        this(context, null);
    }

    public CustomHorizontalView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomHorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CustomHorizontalView(Context context, AttributeSet attrs, int defStyleAttr,
                                int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        // TODO 设计上，该容器的高度取决于第一个的高度，宽度为孩子的宽度之和
        View firstChild = getChildAt(0);
        int childWidth = firstChild.getMeasuredWidth();
        int childHeight = firstChild.getMeasuredHeight();
        if (wSpecMode == MeasureSpec.AT_MOST && hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(childWidth * childCount, childHeight);
        } else if (wSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(childWidth * childCount, hSpecSize);
        } else if (hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(wSpecSize, childHeight);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int offset = 0;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(0);
            int width = child.getMeasuredWidth();
            child.layout(offset, t, offset + width, b);
            offset += width;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastInterceptX;
                int offsetY = y - mLastInterceptX;
                if (Math.abs(offsetX) >= Math.abs(offsetY)) {
                    intercept = true;
                }
                break;
        }
        mLastInterceptX = x;
        mLastInterceptY = y;
        return intercept;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                scrollBy(mLastX - x, 0);
                break;
        }
        mLastX = x;
        mLastY = y;
        return super.onTouchEvent(event);
    }
}

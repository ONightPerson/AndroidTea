package com.liubz.androidtea.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by liubaozhu on 2020/12/20
 */
public class CustomHorizontalView extends ViewGroup {
    private static final String TAG = "CustomHorizontalView";

    private int mLastInterceptX;
    private int mLastInterceptY;
    private int mLastX;
    private int mLastY;
    private int mChildWidth;
    private int mCurIndex = 0;
    private Scroller mScroller;
    private VelocityTracker mTracker;

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
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
        mTracker = VelocityTracker.obtain();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        Log.d(TAG, "onMeasure: childCount: " + childCount);
        if (childCount <= 0) {
            setMeasuredDimension(0, 0);
            setVisibility(GONE);
            return;
        }
        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.d(TAG, "onMeasure: wSpecMode: " + wSpecMode + ", hSpecMode: " + hSpecMode);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        View firstChild = getChildAt(0);
        int childWidth = firstChild.getMeasuredWidth();
        int childHeight = firstChild.getMeasuredHeight();
        Log.d(TAG, "onMeasure: childWidth: " + childWidth + ", childHeight: " + childHeight);
        Log.d(TAG, "onMeasure: AT_MOST: " + MeasureSpec.AT_MOST + ", EXACTLY: " + MeasureSpec.EXACTLY);
        if (wSpecMode == MeasureSpec.AT_MOST && hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(childWidth * childCount, childHeight);
        } else if (wSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(childWidth * childCount, hSpecSize);
        } else if (hSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(wSpecSize, childHeight);
        } else {
            setMeasuredDimension(childWidth * childCount, childHeight);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int offset = 0;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int width = child.getMeasuredWidth();
            mChildWidth = width;
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
                intercept = false;
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                Log.d(TAG, "onInterceptTouchEvent: down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onInterceptTouchEvent: move");
                int offsetX = x - mLastInterceptX;
                int offsetY = y - mLastInterceptY;
                if (Math.abs(offsetX) >= Math.abs(offsetY)) {
                    intercept = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
        }
        mLastX = x;
        mLastY = y;
        mLastInterceptX = x;
        mLastInterceptY = y;
        return intercept;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        mTracker.addMovement(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent: down");
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "onTouchEvent: move");
                scrollBy(mLastX - x, 0);
                break;
            case MotionEvent.ACTION_UP: {
                int distance = getScrollX() - mCurIndex * mChildWidth;
                if (Math.abs(distance) > mChildWidth / 2) {
                    if (distance > 0) {
                        mCurIndex++;
                    } else {
                        mCurIndex--;
                    }
                }
                mTracker.computeCurrentVelocity(1000);
                float vX = mTracker.getXVelocity();
                Log.d(TAG, "onTouchEvent: vX: " + vX);
                if (Math.abs(vX) > 50) {
                    if (vX > 0) {
                        mCurIndex--;
                    } else {
                        mCurIndex++;
                    }
                }
                mCurIndex = mCurIndex < 0 ? 0 :
                        mCurIndex > getChildCount() - 1 ? getChildCount() - 1 : mCurIndex;
                smoothScrollTo(mCurIndex * mChildWidth, 0);
                mTracker.clear();
                break;
            }
        }
        mLastX = x;
        mLastY = y;
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        mScroller.startScroll(scrollX, scrollY, destX - scrollX, destY - scrollY, 1000);
        invalidate();
    }
}

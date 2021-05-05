package com.liubz.androidtea.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;

/**
 * author: created by liubaozhu on 2021/5/15
 * email: liubaozhu@baidu.com
 */
public class RectView extends View {
    private static final String TAG = "RectView";
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final int mRectColor;

    public RectView(Context context) {
        this(context, null);
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RectView);
        mRectColor = ta.getColor(R.styleable.RectView_rectColor, Color.BLUE);
        ta.recycle();
        initDraw();
    }

    private void initDraw() {
        mPaint.setColor(mRectColor);
        mPaint.setStrokeWidth(1.5f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int paddingStart = getPaddingStart();
        int paddingEnd = getPaddingEnd();
        int paddingTop = getPaddingTop();
        int paddingBtm = getPaddingBottom();
        Log.d(TAG, "onDraw: width: " + width + ", height: " + height);
        canvas.drawRect(paddingStart, paddingTop, width - paddingEnd, height - paddingBtm, mPaint);
    }
}

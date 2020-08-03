package com.liubz.androidtea.modules.ui.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.liubz.androidtea.Constants;
import com.liubz.androidtea.R;

@SuppressLint("LongLogTag")
public class CustomArcView extends View {
    private static final String TAG = "CustomArcView" + Constants.CUSTOM_VIEW_SUFFIX;

    private Paint mCirclePaint;
    private int mStrokeWidth;
    private int mEdgeColor;
    private int mFillColor;
    private int mDefEdgeColor;
    private int mDefFillColor;
    private int mDefStrokeWidth;

    public CustomArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context, attrs);
    }

    private void initData(Context cxt, @Nullable AttributeSet attrs) {
        Resources resources = cxt.getResources();
        mDefEdgeColor = resources.getColor(R.color.orange1);
        mDefFillColor = resources.getColor(R.color.orange2);
        mDefStrokeWidth = resources.getDimensionPixelSize(R.dimen.custom_circle_stroke_width);
        TypedArray array = cxt.obtainStyledAttributes(attrs, R.styleable.CustomArcView);
        mEdgeColor = array.getColor(R.styleable.CustomArcView_edgeColor, mDefEdgeColor);
        mFillColor = array.getColor(R.styleable.CustomArcView_fillColor, mDefFillColor);
        mStrokeWidth = array.getDimensionPixelSize(R.styleable.CustomArcView_strokeWidth, mDefStrokeWidth);

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(mStrokeWidth);
        mCirclePaint.setColor(mFillColor);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = getLeft() + mStrokeWidth / 2;
        int top = getTop() + mStrokeWidth / 2;
        int bottom = getBottom() - mStrokeWidth / 2;
        int right = getRight() - mStrokeWidth / 2;

        RectF rect = new RectF(left, top, right, bottom);
        canvas.drawOval(rect, mCirclePaint);
    }
}

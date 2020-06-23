package com.android.liubz.androidtea.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircle extends View {

    private Paint mCirclePaint;


    public CustomCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(Color.BLUE);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        canvas.save();
        canvas.translate(width / 2, height / 2);
        canvas.rotate(135);
        RectF rect = new RectF(-width / 2, -height / 2, width/2, height/2);
        canvas.drawArc(rect, 0, 270, false, mCirclePaint);
    }
}

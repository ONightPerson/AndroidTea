package com.liubz.androidtea.modules.ui.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.liubz.androidtea.Constants;
import com.liubz.androidtea.R;

@SuppressLint("LongLogTag")
public class CustomArcView extends View {
    private static final String TAG = "CustomArcView" + Constants.CUSTOM_VIEW_SUFFIX;

    private RectF mInnerOval;
    private Paint mArcPaint;
    private float mArcWidth;
    private int mArcProgressColor;
    private int mInnerProgressWidth;
    private int mOutterProgressWidth;
    private int mBackgroundWidth;
    private int mShadowColor;


    public CustomArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context);
        initArcPaint();
    }

    private void initData(Context cxt) {
        Resources resources = cxt.getResources();
        mArcWidth = resources.getDimension(R.dimen.custom_view_arc_width);
        mArcProgressColor = resources.getColor(R.color.custom_view_arc_color);
        mInnerProgressWidth = resources.getDimensionPixelSize(R.dimen.custom_view_inner_progress_width);
        mBackgroundWidth = resources.getDimensionPixelSize(R.dimen.custom_view_bg_width);
        mOutterProgressWidth = resources.getDimensionPixelSize(R.dimen.custom_view_outer_progress_width);
        mShadowColor = resources.getColor(R.color.custom_view_text_shadow_color);
        float outerLeft = mOutterProgressWidth + mInnerProgressWidth / 2;
        mInnerOval = new RectF(outerLeft, outerLeft, mBackgroundWidth - outerLeft,
                mBackgroundWidth - outerLeft);
    }

    private void initArcPaint() {
        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setStrokeWidth(mArcWidth);
        mArcPaint.setAntiAlias(true);
        mArcPaint.setStyle(Paint.Style.STROKE);// mArcPaint
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "onDraw: ");
//        drawShape(canvas);
//        drawInnerArc(canvas);
        drawRect(canvas);
    }

    private void drawRect(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        canvas.drawLine(40, 40, 120, 120, paint);

        canvas.save();
        canvas.rotate(-45, 80, 80);
        canvas.drawLine(40, 40, 120, 120, paint);
        canvas.restore();
    }

    private void drawShape(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(12f);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 100, 80, paint);

        paint.setAntiAlias(true);
        canvas.drawCircle(260, 100, 80, paint);

        paint.setAntiAlias(false);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        canvas.drawRect(360, 20, 460, 80, paint);

        // draw triangle
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3f);
        paint.setColor(Color.RED);

        Path path = new Path();
        path.moveTo(0, -100);
        path.lineTo(0, 0);
        path.lineTo(100, 0);
        // line to the start
        path.close();
        path.offset(0, 400);
        canvas.drawPath(path, paint);
        path.offset(400, 0);
        canvas.drawPath(path, paint);
        path.offset(800, 0);
        canvas.drawPath(path, paint);
        // draw line
        paint.setAntiAlias(true);
        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), paint);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint);
        // draw some text using STROKE style
        Paint textPaint = new Paint();
        textPaint.setTextSize(40f);
        textPaint.setShadowLayer(5, 0, 5, mShadowColor);
        textPaint.setColor(Color.MAGENTA);
        textPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("STROKE", getWidth() / 2, getHeight() / 2, textPaint);
        textPaint.setTextScaleX(4);
        canvas.drawText("STROKE", getWidth() / 2, getHeight() / 2 + 60, textPaint);
        textPaint.setFlags(Paint.LINEAR_TEXT_FLAG);
        canvas.drawText("STROKE", getWidth() / 2, getHeight() / 2 + 120, textPaint);
        // draw a bounding text
        int x = getWidth() / 2;
        int y = getHeight() / 2 + 160;
        canvas.save();
        canvas.translate(x, y);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTextSize(30f);
        textPaint.setTextScaleX(1);
        String str = "My Favorite Teacher";
        Rect rect = new Rect();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        Log.e(TAG, "drawShape --> rect with: " + rect.width() + ", 坐标: [(" + rect.left + ", "
                + rect.top + "), (" + rect.right + ", " + rect.bottom + ")]");
        canvas.drawText(str, 0, 0, textPaint);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(2f);
        canvas.drawRect(rect, textPaint);
        canvas.restore();

        canvas.save();
        Log.e(TAG, "drawShape --> exact center cord: ("  + rect.exactCenterX() + ", " + rect.exactCenterY() + ")");
        canvas.rotate(-45, x + rect.exactCenterX(), y + rect.exactCenterY());
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str, x, y, textPaint);
        canvas.restore();

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        DashPathEffect dashPath = new DashPathEffect(new float[]{10, 10}, 2);
        paint.setPathEffect(dashPath);
        canvas.drawLine(0, getHeight() - 50, getWidth(), getHeight() - 40, paint);
    }

    private void drawInnerArc(Canvas canvas) {
        mArcPaint.setColor(mArcProgressColor);
        mArcPaint.setStrokeWidth(mInnerProgressWidth);
//        canvas.drawLine(0f, 150f, 300f, 150f, mArcPaint);
        float offset = 0.5f;
        canvas.drawArc(mInnerOval, 135, 0, false, mArcPaint);
    }
}

package com.liubz.androidtea.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.liubz.androidtea.R;
import com.liubz.androidtea.utils.LogHelper;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/27/24 9:51 AM
 */
public class AnimatableImageView extends AppCompatImageView {
    private static final String TAG = "AnimatableImageView";

    private @DrawableRes int mDrawableResId;

    public AnimatableImageView(@NonNull Context context, @DrawableRes int drawableResId) {
        super(context);
        setImageResource(drawableResId);
    }

    public AnimatableImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimatableImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    public void setImageResource(@DrawableRes int resId) {
        if (mDrawableResId != resId) {
            stopAnimating();
        }
        mDrawableResId = resId;
        if (mDrawableResId != 0) {
            super.setImageResource(mDrawableResId);
        } else {
            super.setImageDrawable(null);
        }
        if (getVisibility() == VISIBLE) {
            startAnimating();
        }
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        mDrawableResId = 0;
        stopAnimating();
        super.setImageDrawable(drawable);
        if (getVisibility() == VISIBLE) {
            startAnimating();
        }
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        switch (visibility) {
            case VISIBLE:
                resetDrawable();
                break;
            case GONE:
            case INVISIBLE:
            default:
                releaseDrawable();
                break;
        }
    }

    @Override
    protected void onAttachedToWindow() {
        LogHelper.i(TAG, "onAttachedToWindow");
        super.onAttachedToWindow();
        resetDrawable();
    }

    @Override
    protected void onDetachedFromWindow() {
        LogHelper.i(TAG, "onDetachedFromWindow");
        releaseDrawable();
        super.onDetachedFromWindow();
    }

    @Override
    public void onStartTemporaryDetach() {
        LogHelper.i(TAG, "onStartTemporaryDetach");
        releaseDrawable();
        super.onStartTemporaryDetach();
    }

    @Override
    public void onFinishTemporaryDetach() {
        LogHelper.i(TAG, "onFinishTemporaryDetach");
        super.onFinishTemporaryDetach();
        resetDrawable();
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs) {
        final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AnimatableImageView);
        int resId = ta.getResourceId(R.styleable.AnimatableImageView_drawableRes, 0);
        if (resId != 0) {
            setImageResource(resId);
        }
        ta.recycle();
    }

    private void resetDrawable() {
        if (getVisibility() == VISIBLE) {
            if (mDrawableResId != 0) {
                super.setImageResource(mDrawableResId);
            }
            startAnimating();
        }
    }

    private void releaseDrawable() {
        stopAnimating();
        if (mDrawableResId != 0) {
            super.setImageDrawable(null);
        }
    }

    private void startAnimating() {
        Drawable curDrawable = getDrawable();
        if (curDrawable != null && curDrawable instanceof Animatable) {
            ((Animatable) curDrawable).start();
        }
    }

    private void stopAnimating() {
        Drawable drawable = getDrawable();
        if (drawable != null && drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
    }
}

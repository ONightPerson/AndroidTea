package com.android.liubz.androidtea.material.behavior;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.android.liubz.androidtea.Constants;

@SuppressLint("LongLogTag")
public class FooterBehavior extends CoordinatorLayout.Behavior<View> {
    private static final String TAG = "FooterBehavior" + Constants.CUSTOM_BEHAVIOR_SUFFIX;

    private int mDirectionChange;

    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull View child, @NonNull View directTargetChild,
                                       @NonNull View target, int axes, int type) {
        Log.i(TAG, "onStartNestedScroll: ");
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                  @NonNull View child, @NonNull View target,
                                  int dx, int dy, @NonNull int[] consumed) {

        Log.i(TAG, "onNestedPreScroll: dx: " + dx + ", dy: " + dy);

        if (dy > 0 && mDirectionChange < 0 || dy < 0 && mDirectionChange > 0) {
            child.animate().cancel();
            mDirectionChange = 0;
        }
        Log.i(TAG, "onNestedPreScroll: mDirectionChange: " + mDirectionChange);
        mDirectionChange += dy;
        if (mDirectionChange > child.getHeight() && child.getVisibility() == View.VISIBLE) {
            Log.i(TAG, "onNestedPreScroll: hide");
            hide(child);
        } else if (mDirectionChange < 0 && child.getVisibility() == View.INVISIBLE) {
            Log.i(TAG, "onNestedPreScroll: show");
            show(child);
        }
    }

    private void show(View view) {
        view.setVisibility(View.VISIBLE);
//        ViewPropertyAnimator animator = view.animate().translationY(0)
//                .setInterpolator(new FastOutSlowInInterpolator())
//                .setDuration(200);
//        animator.setListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                view.setVisibility(View.VISIBLE);
//            }
//        });
//        animator.start();
    }

    private void hide(View view) {
        view.setVisibility(View.INVISIBLE);
//        ViewPropertyAnimator animator = view.animate().translationY(view.getHeight())
//                .setInterpolator(new FastOutSlowInInterpolator())
//                .setDuration(200);
//        animator.setListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                view.setVisibility(View.GONE);
//            }
//        });
//        animator.start();
    }
}

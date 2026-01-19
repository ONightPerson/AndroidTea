package com.liubz.androidtea.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

/**
 * @Desc: 使用 Scroller 实现内容弹性滑动的自定义 View
 * @Author: liubaozhu
 */
public class SmoothScrollView extends LinearLayout {

    private final Scroller mScroller;

    public SmoothScrollView(Context context) {
        this(context, null);
    }

    public SmoothScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 1. 初始化 Scroller
        mScroller = new Scroller(context);
    }

    // 2. 调用 startScroll 开启平滑滑动过程
    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;
        // 参数：起始点X, 起始点Y, 偏移X, 偏移Y, 持续时间
        mScroller.startScroll(scrollX, scrollY, deltaX, deltaY, 1000);
        invalidate(); // 触发重绘，进而调用 computeScroll
    }

    // 3. 系统在绘制时会反复调用此方法
    @Override
    public void computeScroll() {
        // 判断滑动是否还在继续
        if (mScroller.computeScrollOffset()) {
            // 获取当前这一时刻 Scroller 计算出的滑动位置并应用
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            // 继续重绘
            postInvalidate();
        }
    }
}

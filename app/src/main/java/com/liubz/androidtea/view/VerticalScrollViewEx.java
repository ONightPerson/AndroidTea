package com.liubz.androidtea.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @Desc: 同向滑动冲突：自定义父容器 (配合内部拦截法)
 * @Author: liubaozhu
 */
public class VerticalScrollViewEx extends ScrollView {

    public VerticalScrollViewEx(Context context) {
        super(context);
    }

    public VerticalScrollViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 内部拦截法：父容器不能拦截 DOWN，否则子 View 拿不到事件流
            super.onInterceptTouchEvent(ev);
            return false;
        }
        // 其他事件默认拦截，除非子 View 调用 requestDisallowInterceptTouchEvent(true)
        return true;
    }
}

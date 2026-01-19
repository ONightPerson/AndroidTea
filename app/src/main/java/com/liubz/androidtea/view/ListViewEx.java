package com.liubz.androidtea.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * @Desc: 同向滑动冲突：自定义子 ListView (内部拦截法)
 * @Author: liubaozhu
 */
public class ListViewEx extends ListView {
    private int mLastY;

    public ListViewEx(Context context) {
        super(context);
    }

    public ListViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 1. 按下时，禁止父容器拦截
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaY = y - mLastY;
                // 2. 判断是否滑动到了边界
                if (isAtTop() && deltaY > 0) {
                    // 到达顶部且向下拉，允许父容器拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else if (isAtBottom() && deltaY < 0) {
                    // 到达底部且向上拉，允许父容器拦截
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            default:
                break;
        }
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }

    private boolean isAtTop() {
        return getFirstVisiblePosition() == 0 && getChildAt(0) != null && getChildAt(0).getTop() >= 0;
    }

    private boolean isAtBottom() {
        return getLastVisiblePosition() == getCount() - 1 && 
               getChildAt(getChildCount() - 1) != null && 
               getChildAt(getChildCount() - 1).getBottom() <= getHeight();
    }
}

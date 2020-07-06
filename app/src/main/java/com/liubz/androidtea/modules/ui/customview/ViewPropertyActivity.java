package com.liubz.androidtea.modules.ui.customview;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.liubz.androidtea.R;

/**
 * Created by liubaozhu on 2019-05-19
 */
public class ViewPropertyActivity extends Activity implements View.OnTouchListener, View.OnScrollChangeListener {
    private static final String TAG = "ViewPropertyActivity";

    private View mContainer;
    private TextView mTestBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property);

        assignViews();

        getBtnProperty();

        scrollBtn();
    }

    private void scrollBtn() {
        mTestBtn.scrollBy(300, 300);
        Log.e(TAG, "scrollBtn: (mScrollX, mScrollY) = ("
                + mTestBtn.getScrollX() + ", " + mTestBtn.getScrollY() + ")");
        mContainer.scrollBy(100, 100);
    }

    private void assignViews() {
        mContainer = findViewById(R.id.container);
        mContainer.setOnScrollChangeListener(this);
        mTestBtn = findViewById(R.id.test_btn);
        mTestBtn.setOnTouchListener(this);
    }

    private void getBtnProperty() {
        // get touch slop
        Log.i(TAG, "touch slop: " + ViewConfiguration.get(this).getScaledTouchSlop());

        Log.i(TAG, "getBtnProperty: before translation: ");
        printViewProperty(mTestBtn);
        mTestBtn.setTranslationX(12);
        mTestBtn.setTranslationY(6);


        Log.i(TAG, "getBtnProperty: after translation: ");
        printViewProperty(mTestBtn);
    }

    private void printViewProperty(View view) {

        int left = mTestBtn.getLeft();
        int top = view.getTop();
        int right = view.getRight();
        int bottom = view.getBottom();

        float x = view.getX();
        float y = view.getY();

        float transX = view.getTranslationX();
        float transY = view.getTranslationY();
        Log.i(TAG, "getBtnProperty: (left, top) = (" + left + ", " + top + "), "
                + "(right, bottom) = (" + right + ", " + bottom + ");\n"
                + "(x, y) = (" + x + ", " + y + ")\n"
                + "(transX, transY) == (" + transX + ", " + transY + ")");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i(TAG, "onTouch: (x, y) == (" + event.getX() + ", " + event.getY() + ")\n"
                + "(rawX, rawY) == (" + event.getRawX() + ", " + event.getRawY() + ")");
        return false;
    }

    @Override
    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

    }
}

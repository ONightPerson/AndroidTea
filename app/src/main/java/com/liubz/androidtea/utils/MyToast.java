package com.liubz.androidtea.utils;

import com.liubz.androidtea.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;

/**
 * Created by liubaozhu on 2021/3/30
 */
public class MyToast {

    /**
     * 展示toast==LENGTH_SHORT
     *
     * @param msg
     */
    public static void show(@NonNull Context cxt, @NonNull CharSequence msg) {
        showShort(cxt, msg);
    }

    private static void showShort(@NonNull Context cxt, @NonNull CharSequence msg) {
        show(cxt, msg, Toast.LENGTH_SHORT);
    }

    /**
     * 展示toast==LENGTH_LONG
     *
     * @param msg
     */
    public static void showLong(@NonNull Context cxt, @NonNull CharSequence msg) {
        show(cxt, msg, Toast.LENGTH_LONG);
    }


    private static void show(@NonNull Context cxt, @NonNull CharSequence massage, int show_length) {
        //使用布局加载器，将编写的toast_layout布局加载进来
        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(cxt).inflate(R.layout.my_toast_layout, null);
        //获取ImageView
        TextView title = (TextView) view.findViewById(R.id.toast_tv);
        //设置显示的内容
        title.setText(massage);
        Toast toast = new Toast(cxt);
        //设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移70个单位，
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER, 0, 200);
        //设置显示时间
        toast.setDuration(show_length);
        toast.setView(view);
        toast.show();
    }

}

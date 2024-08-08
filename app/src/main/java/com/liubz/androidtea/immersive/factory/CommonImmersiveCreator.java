package com.liubz.androidtea.immersive.factory;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 8/6/24 3:35 PM
 */
public class CommonImmersiveCreator extends ImmersiveCreator {

    @Override
    public void setImmerseStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        // 将FLAG_TRANSLUCENT_STATUS换成FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS，否则状态栏不会完全透明，会有一个半透明的灰色蒙层
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
          | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        View decorView = window.getDecorView();
        // SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN 表示Activity全屏显示，但状态栏不会被隐藏，依然可见
        // SYSTEM_UI_FLAG_LAYOUT_STABLE表示保持整个View稳定，使View不会因为系统UI的变化而重新layout
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
          | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        // FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS表示系统bar的背景将交给window绘制
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);

    }

    @Override
    public void setStatusBarColor(Activity activity, boolean isDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View view = activity.getWindow().getDecorView();
            int oldUiVis = view.getSystemUiVisibility();
            int newUiVis = oldUiVis;
            if (isDark) {
                newUiVis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                newUiVis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
            if (newUiVis != oldUiVis) {
                view.setSystemUiVisibility(newUiVis);
            }
        }
    }
}

package com.liubz.androidtea.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.Window;

import com.liubz.androidtea.R;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/26/24 7:24 PM
 */
public class DialogHelper {

    public static Dialog showProgress(Activity activity) {
        final AlertDialog dialog = new AlertDialog.Builder(activity, R.style.CommonDialog_Progress).create();
        dialog.setCanceledOnTouchOutside(false);
        try {
            if (activity != null && !activity.isFinishing()) {
                dialog.show();
                Window window = dialog.getWindow();
                if (window != null) {
                    window.setContentView(R.layout.common_progress);
                }
                return dialog;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    public static void dismissDialog(Dialog dialog) {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception ignored) {
        }
    }
}

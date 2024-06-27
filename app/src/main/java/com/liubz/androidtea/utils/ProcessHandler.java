package com.liubz.androidtea.utils;

import android.app.Activity;
import android.app.Dialog;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 5/20/24 4:43 PM
 */
public class ProcessHandler {

    protected Activity mContext;
    protected Dialog mProgressDialog;

    public ProcessHandler(Activity context) {
        mContext = context;
    }

    public boolean showProcessDialog() {
        if (mContext == null) {
            return false;
        }
        if (mProgressDialog != null) {
            dismissProcessDialog();
        }
        mProgressDialog = DialogHelper.showProgress(mContext);
        return mProgressDialog != null && mProgressDialog.isShowing();
    }

    /**
     * @return 返回false表示Activity已经finish，dismiss失败
     */
    public boolean dismissProcessDialog() {
        if (mContext == null) {
            return false;
        }
        if (mContext.isFinishing()) {
            return false;
        }
        DialogHelper.dismissDialog(mProgressDialog);
        mProgressDialog = null;
        return true;
    }
}

package com.liubz.androidtea.broadcast;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 12/12/23 3:35 PM
 */
public class SimStateReceiver extends BroadcastReceiver {
    private static final String TAG = "SimStateReceiver";
    public final static String ACTION_SIM_STATE_CHANGED = "android.telephony.action.SIM_CARD_STATE_CHANGED"; // 无法监听，属于SystemApi
    private OnSimChangeListener onSimSwitchListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: action: " + intent.getAction());
        if (ACTION_SIM_STATE_CHANGED.equals(intent.getAction())) {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
            int state = tm.getSimState();
            if (onSimSwitchListener != null) {
                onSimSwitchListener.simValid(state == TelephonyManager.SIM_STATE_READY);
            }
        }
    }

    public void setOnSimSwitchListener(OnSimChangeListener onSimSwitchListener) {
        this.onSimSwitchListener = onSimSwitchListener;
    }

    public interface OnSimChangeListener {
        void simValid(boolean valid);
    }
}

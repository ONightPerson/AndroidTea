package com.liubz.androidtea.network;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.liubz.androidtea.Constants;

public class WiFiHelper {
    private static final String TAG = "WiFiHelper" + Constants.NETWORK_SUFFIX;


    private static volatile WiFiHelper mHelper;
    private WifiManager mWiFiManager;
    private Context mContext;

    public WiFiHelper(Context context) {
        mContext = context.getApplicationContext();
        mWiFiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
    }

    public static WiFiHelper getInstance(Context cxt) {
        if (mHelper == null) {
            synchronized (WiFiHelper.class) {
                if (mHelper == null) {
                    mHelper = new WiFiHelper(cxt);
                }
            }
        }
        return mHelper;
    }

    public WifiInfo getConnectionInfo() {
        try {
            WifiInfo info = mWiFiManager.getConnectionInfo();
            return info;
        } catch (Throwable e) {
            Log.e(TAG, "getConnectionInfo: ", e);
        }
        return null;
    }
}

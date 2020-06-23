package com.android.liubz.androidtea.network;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.wifi.WifiInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.liubz.androidtea.CommonHandler;
import com.android.liubz.androidtea.Constants;
import com.android.liubz.androidtea.R;

import java.lang.ref.WeakReference;

@SuppressLint("LongLogTag")
public class SignalStrengthTestActivity extends Activity implements CommonHandler.MessageHandler {
    private static final String TAG = "SignalStrengthTestActivity" + Constants.NETWORK_SUFFIX;

    private static final int COUNT_EXEC = 10;
    private static final long INTERVAL_TASK = 1000l;
    private static final long INTERVAL_SIGNAL_STRENGTH_TASK = COUNT_EXEC * INTERVAL_TASK;

    private static final int TYPE_REFRESH_SIGNAL_STRENGTH = 0;
    private static final int TYPE_TASK_CANCEL = 1;
    private static final int TYPE_TASK_FINISH = 2;

    private static final int MSG_UPDATE_TIME = 0;
    private static final float COUNT = (float) 270 / 4;

    private Handler mHandler = new CommonHandler(this);

    private TextView mSignalStrengthTextView;
    private TextView mTimeRemainTextView;
    private SignalStrengthFetchTask mStrengthTask;
    private int mTimeRemain;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signal_strength_test);
        initViews();
        Log.i(TAG, "onCreate: COUNT: " + COUNT);
    }

    private void initViews() {
        mSignalStrengthTextView = findViewById(R.id.strength_value);
        mTimeRemainTextView = findViewById(R.id.time_remain);
    }


    public void startSignalStrengthTest(View v) {
        Log.i(TAG, "startSignalStrengthTest");
        if (mStrengthTask != null && !mStrengthTask.isCancelled()) {
            Toast.makeText(this, "强度测试任务正在进行", Toast.LENGTH_SHORT).show();
            return;
        }
        mStrengthTask = new SignalStrengthFetchTask(this);
        mStrengthTask.execute();
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                if (mStrengthTask != null && !mStrengthTask.isCancelled()) {
//                    mStrengthTask.cancel(true);
//                }
//            }
//        }, INTERVAL_SIGNAL_STRENGTH_TASK);
        initTimeRemain(COUNT_EXEC);
        refreshTimeRemain(mTimeRemain);
        mHandler.sendEmptyMessageDelayed(MSG_UPDATE_TIME, INTERVAL_TASK);
    }

    public void stopSignalStrengthTest(View view) {
        mHandler.removeMessages(MSG_UPDATE_TIME);
        if (mStrengthTask != null && !mStrengthTask.isCancelled()) {
            mTimeRemainTextView.setVisibility(View.GONE);
            mStrengthTask.cancel(true);
            mStrengthTask = null;
        } else {
            Toast.makeText(this, "强度测试任务已取消", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_UPDATE_TIME:
                Log.i(TAG, "handleMessage --> deal with MSG_UPDATE_TIME");
                if (mTimeRemain > 0) {
                    mTimeRemain--;
                    refreshTimeRemain(mTimeRemain);
                    mHandler.sendEmptyMessageDelayed(MSG_UPDATE_TIME, INTERVAL_TASK);
                } else {
                    mTimeRemainTextView.setVisibility(View.GONE);
                    if (mStrengthTask != null && !mStrengthTask.isCancelled()) {
                        mStrengthTask.cancel(true);
                    }
                }
                break;
            default:
                break;
        }
    }


    private static class SignalStrengthFetchTask extends AsyncTask<Void, Integer, Void> {

        WeakReference<SignalStrengthTestActivity> activityRef;
        WiFiHelper wiFiHelper;

        SignalStrengthFetchTask(SignalStrengthTestActivity outer) {
            activityRef = new WeakReference<>(outer);
            wiFiHelper = WiFiHelper.getInstance(outer);
        }


        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute: ");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while (true) {
                Log.i(TAG, "doInBackground --> work start");
                if (isCancelled()) {
                    Log.i(TAG, "doInBackground --> judge cancel flag");
                    break;
                }

                WifiInfo wifiInfo = wiFiHelper.getConnectionInfo();
                Log.i(TAG, "doInBackground: wifiinfo: " + wifiInfo);
                if (wifiInfo != null) {
                    long cur = SystemClock.elapsedRealtime();
                    int signalStrength = wifiInfo.getRssi();
                    Log.i(TAG, "get rssi spend time: " + (SystemClock.elapsedRealtime() - cur));
                    publishProgress(signalStrength);
                } else if (activityRef != null) {
//                    Toast.makeText(activityRef.get(), "无法获取WifiInfo", Toast.LENGTH_SHORT).show();
//                    break;
                }

                try {
                    SystemClock.sleep(1000);
                } catch (Throwable t) {
                    Log.e(TAG, "doInBackground: ", t);
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if (activityRef != null) {
                SignalStrengthTestActivity activity = activityRef.get();
                activity.refreshSignalStrengthResult(TYPE_REFRESH_SIGNAL_STRENGTH, values[0]);
            }

        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            if (activityRef != null) {
                activityRef.get().refreshSignalStrengthResult(TYPE_TASK_FINISH);
            }
        }

        @Override
        protected void onCancelled() {
            Log.i(TAG, "onCancelled");
            if (activityRef != null) {
                SignalStrengthTestActivity activity = activityRef.get();
                activity.refreshSignalStrengthResult(TYPE_TASK_CANCEL);
            }

        }
    }

    private void initTimeRemain(int remain) {
        mTimeRemainTextView.setVisibility(View.VISIBLE);
        mTimeRemain = remain;
    }

    private void refreshTimeRemain(int remain) {
        mTimeRemainTextView.setText(getString(R.string.network_signal_strength_time_remain, remain));
    }

    private void refreshSignalStrengthResult(int type) {
        refreshSignalStrengthResult(type, 0);
    }

    private void refreshSignalStrengthResult(int type, int strength) {
        switch (type) {
            case TYPE_REFRESH_SIGNAL_STRENGTH:
                mSignalStrengthTextView.setText(getString(
                        R.string.network_signal_strength_value_display, strength));
                break;
            case TYPE_TASK_FINISH:
                mSignalStrengthTextView.setText(R.string.network_signal_strength_task_finish);
                break;
            case TYPE_TASK_CANCEL:
                mSignalStrengthTextView.setText(R.string.network_signal_strength_task_cancel);
                break;
            default:
                break;

        }

    }
}

package com.liubz.androidtea.rx;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.liubz.androidtea.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;

/**
 * Created by liubaozhu on 2021/4/15
 */
public class RxActivity extends Activity {
    private static final String TAG = "RxActivity";

    private Subscriber<String> subscriber = new Subscriber<String>() {
        @Override
        public void onSubscribe(Subscription s) {
            Log.d(TAG, "onSubscribe");
        }

        @Override
        public void onNext(String s) {
            Log.d(TAG, "onNext");
        }

        @Override
        public void onError(Throwable t) {
            Log.d(TAG, "onError");
        }

        @Override
        public void onComplete() {
            Log.d(TAG, "onComplete");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_layout);
    }

}

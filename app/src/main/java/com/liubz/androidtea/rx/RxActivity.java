package com.liubz.androidtea.rx;

import com.liubz.androidtea.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by liubaozhu on 2021/4/15
 */
public class RxActivity extends Activity {
    private static final String TAG = "RxActivity";

    private final Observer<String> observer = new Observer<String>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            Log.d(TAG, "onSubscribe");
        }

        @Override
        public void onNext(@NonNull String s) {
            Log.d(TAG, "onNext: " + s);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            Log.e(TAG, "onError: ", e);
        }

        @Override
        public void onComplete() {
            Log.d(TAG, "onComplete: ");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_layout);
//        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
//                emitter.onNext("杨思颖");
//                emitter.onNext("月眉儿");
//                emitter.onComplete();
//            }
//        });
//        observable.subscribe(observer);
        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                if (time % 2 != 0) {
                    emitter.onError(new IllegalStateException("Odd millisecond!"));
                    break;
                }
            }
        }).subscribe(System.out::println, Throwable::printStackTrace);
    }

}

package com.liubz.androidtea.rx;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import java.io.IOException;
import java.util.Arrays;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2022/11/3 9:03 PM
 */
public class RxActivity extends FragmentActivity {
    private static final String TAG = "RxActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        handleData();
        handleProvinces();
    }

    public interface Operator<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
        // cover for generics insanity
    }

    class Cities {}


    private void handleProvinces() {
        Observable.from(new String[]{"GuangDong", "Chongqing"})
                .flatMap(new Func1<String, Observable<? extends Cities>>() {
                    @Override
                    public Observable<? extends Cities> call(String s) {
                        return null;
                    }
                })
                .subscribe(new Action1<Cities>() {
                    @Override
                    public void call(Cities s) {

                    }
                });

    }

    private void handleData() {
        AssetManager assetManager = getAssets();
        String[] files = new String[0];
        try {
            files = assetManager.list("");
            Log.i(TAG, "handleData: files," + Arrays.toString(files));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Observable.from(files)
//                .flatMap(new Func1<String, Observable<String>>() {
//                    @Override
//                    public Observable<String> call(String file) {
//                        return Observable.from(file.listFiles());
//                    }
//                })
                .filter(s -> {
                    Log.i(TAG, "call: s" + s);
                    return s.endsWith(".png");
                })
                .map(file -> file)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bitmap -> {
                    Log.i(TAG, "bitmap: " + bitmap);
                    ;
                });

    }

}

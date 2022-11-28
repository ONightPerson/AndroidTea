package com.liubz.androidtea.rx;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
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
//        handleProvinces();
//        testToMap();
        testRxOkHttp();
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

    class SwordMan {
        public String name;
        public String level;
        public SwordMan(String name, String level) {
            this.name = name;
            this.level = level;
        }
    }

    private void testToMap() {
        SwordMan s1 = new SwordMan("韦一笑", "A");
        SwordMan s2 = new SwordMan("周芷若", "SS");
        SwordMan s3 = new SwordMan("张三丰", "A");
        SwordMan s4 = new SwordMan("张无忌", "S");

        Observable.just(s1, s2, s3, s4).toMap(new Func1<SwordMan, String>() {
            @Override
            public String call(SwordMan swordMan) {
                return swordMan.level;
            }
        }).subscribe(new Action1<Map<String, SwordMan>>() {
            @Override
            public void call(Map<String, SwordMan> stringSwordManMap) {
                Log.i(TAG, "toMap: " + stringSwordManMap.get("S").name);
            }
        });
    }

    private Observable<String> getObservable(final String ip) {
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody formBody = new FormBody.Builder()
                        .add("ip", ip)
                        .build();
                Request request = new Request.Builder()
                        .url("https://ip.taobao.com/service/getIpInfo.php")
                        .post(formBody)
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        subscriber.onError(new Exception("error"));
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        if (response == null) {
                            subscriber.onError(new Exception("response is null"));
                        }
                        String str = response.body().string();
                        subscriber.onNext(str);
                        subscriber.onCompleted();
                    }
                });
            }
        });
        return observable;
    }

    private void testRxOkHttp() {
        getObservable("125.36.180.208")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s);
                        Toast.makeText(RxActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}

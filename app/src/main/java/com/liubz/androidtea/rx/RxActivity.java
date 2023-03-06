package com.liubz.androidtea.rx;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;


/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/3/2 5:07 PM
 */
public class RxActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("RxActivity");

        hello("Kitty", "Snoopy", "Shriek");
//        just("one object");
        sendInteger();
    }

    public static void hello(String... args) {
        Flowable.fromArray(args).subscribe(s -> System.out.println("hello " + s + "!"));
    }

    public static void sendInteger() {
        Observable.fromArray(1, 2, 3, 4).subscribe(System.out::println);
    }

    public static void just(String str) {
        Observable.just(str).subscribe(s -> System.out.println("hello " + s + "!"));
    }

}

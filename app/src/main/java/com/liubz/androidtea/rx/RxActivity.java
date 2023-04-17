package com.liubz.androidtea.rx;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;

import java.util.concurrent.Callable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;


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

//        hello("Kitty", "Snoopy", "Shriek");
//        just("one object");
//        sendInteger();
        handleNormalAndException();
    }

    public static void hello(String... args) {
        Flowable.fromArray(args).subscribe(s -> System.out.println("hello " + s + "!"));
        Flowable.fromArray(args).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                System.out.println("hello" + s);
            }
        });
    }

    public static void sendInteger() {
        Observable.fromArray(1, 2, 3, 4).subscribe(System.out::println);
    }

    public static void just(String str) {
        Observable.just(str).subscribe(s -> System.out.println("hello " + s + "!"));
    }

    public static void handleNormalAndException() {
        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                if (time % 2 != 0) {
                    emitter.onNext(new IllegalStateException("Odd millisecond"));
                    break;
                }
            }
        }).subscribe(System.out::println, Throwable::printStackTrace);
        for (int i = 0; i < 100000000000000L; i++) {

        }

    }

    public static void waitBackgroundComputation() {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000); // imitate expensive computation
            return "Done";
        })
          .subscribeOn(Schedulers.io())
          .observeOn(Schedulers.single())
          .subscribe(System.out::println, Throwable::printStackTrace);
    }
}

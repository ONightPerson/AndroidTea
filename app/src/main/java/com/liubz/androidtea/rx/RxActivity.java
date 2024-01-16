package com.liubz.androidtea.rx;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;


/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/3/2 5:07 PM
 */
public class RxActivity extends BaseActivity {
    private static final String TAG = "RxActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("RxActivity");

//        hello("Kitty", "Snoopy", "Shriek");
        just("one object");
//        sendInteger();
//        handleNormalAndException();
//        create();
//        showCourses();

    }

    //    public static void hello(String... args) {
//        Flowable.fromArray(args).subscribe(s -> System.out.println("hello " + s + "!"));
//        Flowable.fromArray(args).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Throwable {
//                System.out.println("hello" + s);
//            }
//        });
//    }
//
//    public static void sendInteger() {
//        Observable.fromArray(1, 2, 3, 4).subscribe(System.out::println);
//    }
//
    public static void just(String str) {
        Observable<String> o1 = Observable.just(null);
        Observable<String> o2 = Observable.just(str).mergeWith(o1);
//        Observable.just(str).mergeWith(o1).subscribe(s -> System.out.println("hello " + s + "!"));

        Observable<String> o3 = Observable.just("llllllll");
        Observable<String> o4 = Observable.combineLatest(o2, o3, new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + s2;
            }
        });
        o4.map(new Func1<String, Repo>() {
            @Override
            public Repo call(String s) {
                return new Repo(s);
            }
        }).subscribeOn(Schedulers.io()).subscribe(s -> System.out.println("hello " + s + "!"));
    }

    static class Repo {
        Repo(String name) {
            this.name = name;
        }
        String name;
    }
//
//    public static void handleNormalAndException() {
//        Observable
//          .create(emitter -> {
//              while (!emitter.isDisposed()) {
//                  long time = System.currentTimeMillis();
//                  emitter.onNext(time);
//                  if (time % 2 != 0) {
//                      emitter.onNext(new IllegalStateException("Odd millisecond"));
//                      break;
//                  }
//              }
//          })
//          .subscribe(System.out::println, Throwable::printStackTrace);
//        for (int i = 0; i < 100000000000000L; i++) {
//
//        }
//
//    }
//
//    public static void waitBackgroundComputation() {
//        Flowable.fromCallable(() -> {
//            Thread.sleep(1000); // imitate expensive computation
//            return "Done";
//        })
//          .subscribeOn(Schedulers.io())
//          .observeOn(Schedulers.single())
//          .subscribe(System.out::println, Throwable::printStackTrace);
//    }

    public static void requestAndRenderImageView() {
//        File[] folders = new File[4];
//        Observable.fromArray(folders).flatMap(new Function<File, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(File file) throws Throwable {
//                return Observable.fromArray(file.listFiles());
//            }
//        }).filter(new Predicate<Serializable>() {
//            @Override
//            public boolean test(Serializable serializable) throws Throwable {
//                return false;
//            }
//        })
    }

    public static void create() {
        // 其中OnSubscribe对象的作用相当于一个计划表，当Observable被订阅的时候
//        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello");
//                subscriber.onNext("Hi");
//                subscriber.onCompleted();
//
//            }
//        });

        Observable.just(1, 2, 3).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.i(TAG, "call: number: " + integer);
            }
        });
    }

    private static void outputString() {
        String[] strs = new String[7];
        Observable.from(strs).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(TAG, "call: s: " + s);
            }
        });
    }

    private static void showCourses() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("语文"));
        courses.add(new Course("数学"));
        Student student = new Student();
        student.name = "小明";
        student.courses = courses;
        Observable originObservable = Observable.from(new Student[]{student, student});
        Observable newObservable = originObservable.flatMap(new Func1<Student, Observable<Course>>() {
            @Override
            public Observable<Course> call(Student student) {
                Observable<Course> observable = Observable.from(student.courses);
                return observable;
            }
        });
        newObservable.subscribe(new Action1<Course>() {
            @Override
            public void call(Course course) {
                Log.i(TAG, "call: course: " + course);
            }
        });
    }
}

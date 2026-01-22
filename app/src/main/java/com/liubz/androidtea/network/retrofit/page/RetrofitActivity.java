package com.liubz.androidtea.network.retrofit.page;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.databinding.ActivityRetrofitBinding;
import com.liubz.androidtea.network.retrofit.service.SuggestService;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @Desc: 使用 RxJava 3 优化后的网络请求页面
 * @Author: liubaozhu
 */
@AndroidEntryPoint
public class RetrofitActivity extends BaseActivity {

    private static final String TAG = "RetrofitActivity";
    
    @Inject
    SuggestService mSuggestService;
    
    private ActivityRetrofitBinding binding;
    
    // 管理 RxJava 订阅关系，防止内存泄漏
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRetrofitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Retrofit + RxJava3");

        binding.dictSuggest.setOnClickListener(v -> dictSuggest());
    }

    private void dictSuggest() {
        // 使用 RxJava 3 链式调用
//        mDisposable.add();
        mSuggestService.getSuggest("中国")
                .subscribeOn(Schedulers.io())               // 1. 在 IO 线程发起网络请求
                .observeOn(AndroidSchedulers.mainThread())  // 2. 在主线程处理结果
                .subscribe(suggest -> {
                    // 3. 成功回调
                    Log.i(TAG, "RxJava --> suggest: " + suggest.toString());
                    // 在此处更新 UI，例如：binding.tvResult.setText(suggest.toString());
                }, throwable -> {
                    // 4. 失败回调
                    Log.e(TAG, "RxJava --> Error: ", throwable);
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 关键：Activity 销毁时切断所有订阅，防止异步回调导致崩溃或泄漏
        mDisposable.clear();
    }
}

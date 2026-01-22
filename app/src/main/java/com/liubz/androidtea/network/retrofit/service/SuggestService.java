package com.liubz.androidtea.network.retrofit.service;

import com.liubz.androidtea.network.retrofit.data.Suggest;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Desc: 优化后的 SuggestService，支持 RxJava 3
 * @Author: liubaozhu
 */
public interface SuggestService {

    @GET("https://dict.youdao.com/suggest?num=5&ver=3.0&doctype=json&cache=false&le=en")
    Observable<Suggest> getSuggest(@Query("q") String q);
}

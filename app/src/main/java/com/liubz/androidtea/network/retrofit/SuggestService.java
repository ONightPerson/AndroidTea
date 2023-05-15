package com.liubz.androidtea.network.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * JSON API 免费接口 https://www.bejson.com/knownjson/webInterface/
 * 有道词典：https://dict.youdao.com/suggest?num=5&ver=3.0&doctype=json&cache=false&le=en&q=查词
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/5/12 4:57 PM
 */
public interface SuggestService {


    @GET("https://dict.youdao.com/suggest?num=5&ver=3.0&doctype=json&cache=false&le=en")
    Call<Suggest> getCall(@Query("q") String q);
}

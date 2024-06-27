package com.liubz.androidtea.network.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/27/24 7:48 PM
 */
public class RetrofitManager {
    private static volatile Retrofit sRetrofit;

    public static Retrofit get() {
        if (sRetrofit == null) {
            synchronized (RetrofitManager.class) {
                if (sRetrofit == null) {
                    sRetrofit = createRetrofit();
                }
            }
        }
        return sRetrofit;
    }

    private static Retrofit createRetrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
          .connectTimeout(60, TimeUnit.SECONDS)
          .readTimeout(10, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com")
          .client(okHttpClient)
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        return retrofit;
    }
}

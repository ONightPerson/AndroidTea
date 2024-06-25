package com.liubz.androidtea.di.dagger2;

import dagger.Module;
import retrofit2.Retrofit;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/19/24 7:46 PM
 */
@Module
public class NetworkModule {

    public LoginRetrofitService provideLoginRetrofitService() {
        return new Retrofit.Builder().baseUrl("https://example.com").build().create(LoginRetrofitService.class);
    }

}

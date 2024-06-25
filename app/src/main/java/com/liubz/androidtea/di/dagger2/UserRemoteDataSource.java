package com.liubz.androidtea.di.dagger2;

import javax.inject.Inject;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/19/24 7:38 PM
 */
public class UserRemoteDataSource {
    private final LoginRetrofitService loginRetrofitService;

    @Inject
    public UserRemoteDataSource(LoginRetrofitService loginRetrofitService) {
        this.loginRetrofitService = loginRetrofitService;
    }
}

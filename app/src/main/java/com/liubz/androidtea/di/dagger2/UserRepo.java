package com.liubz.androidtea.di.dagger2;

import javax.inject.Inject;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/19/24 7:25 PM
 */
public class UserRepo {
    private final UserLocalDataSource userLocalDataSource;
    private final UserRemoteDataSource userRemoteDataSource;

    @Inject
    public UserRepo(UserLocalDataSource userLocalDataSource, UserRemoteDataSource userRemoteDataSource) {
        this.userLocalDataSource = userLocalDataSource;
        this.userRemoteDataSource = userRemoteDataSource;
    }
}

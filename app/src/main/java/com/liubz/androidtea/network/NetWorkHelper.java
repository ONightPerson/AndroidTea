package com.liubz.androidtea.network;

import com.liubz.androidtea.network.retrofit.RetrofitManager;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/27/24 7:44 PM
 */
public class NetWorkHelper {

    public static <T> T getService(Class<T> serviceClass) {
        return RetrofitManager.get().create(serviceClass);
    }
}

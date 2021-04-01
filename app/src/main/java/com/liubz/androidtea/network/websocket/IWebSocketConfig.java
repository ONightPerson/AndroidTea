package com.liubz.androidtea.network.websocket;

import androidx.annotation.NonNull;

/**
 * Created by liubaozhu on 2021/4/1
 */
public interface IWebSocketConfig {

    void initConfig();

    void connect();

    void send(@NonNull String msg);

    void close();

    void reConnect();

}

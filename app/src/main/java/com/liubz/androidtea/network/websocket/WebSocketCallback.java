package com.liubz.androidtea.network.websocket;

import androidx.annotation.Nullable;

/**
 * Created by liubaozhu on 2021/4/1
 */
public interface WebSocketCallback {

    void onOpen();

    void onMessage(@Nullable String msg);

    void onClose();

    void onConnectError(@Nullable Throwable t);
}

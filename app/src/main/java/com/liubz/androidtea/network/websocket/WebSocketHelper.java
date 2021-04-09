package com.liubz.androidtea.network.websocket;

import androidx.annotation.NonNull;

/**
 * Created by liubaozhu on 2021/4/1
 */
public class WebSocketHelper {

    private static IWebSocketConfig sConfig;

    private static void ensureConfigSetup() {
        if (sConfig == null) {
            throw new RuntimeException("lib not configured");
        }
    }

    public static void init(@NonNull IWebSocketConfig config) {
        sConfig = config;
    }

    public static void initConfig() {
        ensureConfigSetup();
        sConfig.initConfig();
    }

    public static void connect() {
        ensureConfigSetup();
        sConfig.connect();
    }

    public static void reConnect() {
        ensureConfigSetup();
        sConfig.reConnect();
    }

    public static void send(@NonNull String msg) {
        ensureConfigSetup();
        sConfig.send(msg);
    }

    public static void close() {
        ensureConfigSetup();
        sConfig.close();
    }

    public static void setSocketIOCallBack(WebSocketCallback callBack) {
        ensureConfigSetup();
        sConfig.setSocketIOCallBack(callBack);
    }

    public static void removeSocketIOCallBack() {
        ensureConfigSetup();
        sConfig.removeSocketIOCallBack();
    }
}

package com.liubz.androidtea.utils;

import android.content.Context;

import java.io.File;
import java.io.IOException;

public class HttpUtils {
    private static final String TAG = "DxHttpUtils";

    private static final String PARAMETER_SEPARATOR = "&";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String UTF_8 = "UTF-8";

    public static String commonPost(Context cxt, String url, String body, String extraParams)
            throws IOException {
        DxOKHttpClient httpClient = DxOKHttpClient.createInstance();
        return httpClient.commonPost(cxt, url, body);
    }

    public static String commonGet(Context cxt, String url)
            throws IOException {
        DxOKHttpClient httpClient = DxOKHttpClient.createInstance();
        return httpClient.commonGet(cxt, url);
    }

    public static void commonDownload(Context cxt, String url, File targetFile) throws IOException {
        DxOKHttpClient httpClient = DxOKHttpClient.createInstance();
        httpClient.commonDownload(cxt, url, targetFile);
    }
}

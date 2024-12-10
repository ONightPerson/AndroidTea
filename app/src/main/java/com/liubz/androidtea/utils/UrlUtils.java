package com.liubz.androidtea.utils;

import android.net.Uri;
import android.text.TextUtils;

/**
 * @desc
 * @author: liubaozhu
 * @date: 12/10/24
 */
public class UrlUtils {
    public static String removeUrlParametersAndHash(String urlString) {
        if (TextUtils.isEmpty(urlString)) {
            return "";
        }
        try {
            Uri uri = Uri.parse(urlString);
            // 构建不包含查询参数和哈希的新 Uri
            Uri newUri = uri.buildUpon().clearQuery().fragment(null).build();
            return newUri.toString();
        } catch (Throwable t) {
            return "";
        }

    }
}
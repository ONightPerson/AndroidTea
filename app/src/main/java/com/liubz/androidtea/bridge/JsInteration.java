package com.liubz.androidtea.bridge;

import android.webkit.JavascriptInterface;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/3/3 7:39 PM
 */
public class JsInteration {

    @JavascriptInterface
    public String back() {
        return "Hello, Android World";
    }
}

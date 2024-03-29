package com.liubz.androidtea.network;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.JsonPrimitive;
import com.liubz.androidtea.R;
import com.liubz.androidtea.bridge.JsInteration;


/**
 * author: created by liubaozhu on 2020/5/1
 * email: liubaozhu@baidu.com
 */
public class WebViewTestActivity extends Activity {
    private static final String TAG = "WebViewTestActivity";

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_test);

        initViews();

    }

    private void initViews() {
        mWebView = findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);

        // Create an unencoded HTML string
        // then convert the unencoded HTML string into bytes, encode
        // it with Base64, and load the data.
//        String unencodedHtml =
//                "&lt;html&gt;&lt;body&gt;'%23' is the percent code for ‘#‘ &lt;/body&gt;&lt;/html&gt;";
//        String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(),
//                Base64.NO_PADDING);
//        mWebView.loadData(encodedHtml, "text/html", "base64");
        // 启用WebView调试
        mWebView.setWebContentsDebuggingEnabled(true);
        mWebView.addJavascriptInterface(new JsInteration(mWebView), "bridge");
        mWebView.loadUrl("https://onightperson.github.io/demo/index.html");

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i(TAG, "onPageStarted: ");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i(TAG, "onPageFinished: onPageFinished");

                mWebView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String js = "var newscript = document.createElement(\"script\");";
                        js += "newscript.src=\"https://awp-assets.meituan.net/bepfe/sqt-testtools/test_tool/js/index.bundle.js\";";
                        js += "document.body.appendChild(newscript);";
                        mWebView.loadUrl("javascript:" + js);
                    }
                }, 3000L);
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                Log.i(TAG, "shouldInterceptRequest: " + request);
                return super.shouldInterceptRequest(view, request);
            }

            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                Log.i(TAG, "shouldInterceptRequest: " + url);
                return super.shouldInterceptRequest(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.i(TAG, "shouldOverrideUrlLoading: ");
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG, "shouldOverrideUrlLoading: url -> " + url);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

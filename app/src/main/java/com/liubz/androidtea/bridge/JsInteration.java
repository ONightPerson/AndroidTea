package com.liubz.androidtea.bridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/3/3 7:39 PM
 */
public class JsInteration {
    private static final String TAG = "JsInteration";

    private WebView webview;

    public JsInteration(WebView webView) {
        this.webview = webView;
    }

    @JavascriptInterface
    public String back() {
        return "Hello, Android World";
    }

    @JavascriptInterface
    public void send(final String cmd, String data, final String callbackId) {
        if ("notify".equals(cmd)) {
            try {
                JSONObject jsonObject = new JSONObject(data);
                JSONObject dataJson = jsonObject.getJSONObject("data");
                String name = dataJson.getString("name");
                String addr = dataJson.getString("addr");
                Log.d(TAG, "notify " + name + " in " + addr);
                String callback = String.format("javascript:window.bridge.onReceive(\'%1$s\', \'%2$s\');", callbackId, "result");
                webview.loadUrl(callback);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

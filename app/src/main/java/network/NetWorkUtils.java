package network;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NetWorkUtils {

    public static void show(WebView webView, String url) {

        if (webView == null) {
            return;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    public static void display() {
    }
}

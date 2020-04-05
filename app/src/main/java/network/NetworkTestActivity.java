package network;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.android.liubz.androidtea.R;

public class NetworkTestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classloader_test);

        WebView webView = findViewById(R.id.webview);
        NetWorkUtils.show(webView, "http://www.baidu.com");
        NetWorkUtils.display();
    }
}

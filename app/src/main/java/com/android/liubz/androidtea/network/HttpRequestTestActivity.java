package com.android.liubz.androidtea.network;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.liubz.androidtea.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * author: created by liubaozhu on 2020/5/1
 * email: liubaozhu@baidu.com
 */
public class HttpRequestTestActivity extends Activity implements HttpUtils.HttpRequestListener {
    private static final String TAG = "HttpRequestTestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpurlconnection_test);
    }

    public void httpUrlConnectionGetContent(View view) {
        HttpUtils.sendUrlConnRequest("http://192.168.31.75/myJson.txt", this);

    }

    public void okHttpGetContent(View view) {
        HttpUtils.sendOkHttpRequest("http://192.168.31.75/myJson.txt", new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, "onFailure: ", e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.i(TAG, "onResponse: response: " + response.body().string());
            }
        });
    }

    private void showResponse(String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView tv = findViewById(R.id.content);
                tv.setText(response);
            }
        });
    }

    private void parseResponseWithPull(String response) throws XmlPullParserException, IOException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(response));
        int eventType = parser.getEventType();
        Log.i(TAG, "parseResponse: eventType: " + eventType);
        String to = null;
        String from = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = parser.getName();
            Log.i(TAG, "parseResponse: eventType: " + eventType);
            Log.i(TAG, "parseResponse: nodeName: " + nodeName);
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if ("to".equals(nodeName)) {
                        to = parser.nextText();
                        Log.i(TAG, "parseResponse: solid: " + from);
                    } else if ("from".equals(nodeName)) {
                        from = parser.nextText();
                        Log.i(TAG, "parseResponse: corners: " + from);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("note".equals(nodeName)) {
                        Log.i(TAG, "parseResponse: solid: " + to + ", corners: " + from);
                    }
                    break;
                default:
                    break;
            }
            eventType = parser.next();
        }
    }

    private void parseResponseWithSax(String response) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new InputSource(new StringReader(response)), new ContentHandler());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void parseResponseWithGson(String response) {
        Gson gson = new Gson();
        List<Person> personList = gson.fromJson(response, new TypeToken<List<Person>>(){}.getType());
        Log.i(TAG, "parseResponseWithGson: personList: " + Arrays.toString(personList.toArray(
                new Person[personList.size()])));
    }

    @Override
    public void onSuc(String response) {
        Log.i(TAG, "onSuc: response: " + response);
        parseResponseWithGson(response);
    }

    @Override
    public void onError(Exception e) {
        Log.e(TAG, "onError: ", e);
    }
}

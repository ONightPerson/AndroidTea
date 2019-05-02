package com.android.liubz.androidtea.download;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {
    private static final String TAG = "HttpUtils";

    public static void createURI() {
        List<NameValuePair> qparams = new ArrayList<>();
        qparams.add(new BasicNameValuePair("q", "httpclient") );
        qparams.add(new BasicNameValuePair("btnG", "Google Search"));
        qparams.add(new BasicNameValuePair("aq", "f"));
        qparams.add(new BasicNameValuePair("oq", null));
        URI uri = null;
        try {
            uri = URIUtils.createURI("http", "www.google.com", -1,
                    "/search",
                    URLEncodedUtils.format(qparams, "UTF-8"), null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpGet httpget = new HttpGet(uri);
        Log.i(TAG, "main: uri: " + httpget.getURI());
    }

    /**
     * 通过HttpClient get 访问http
     * @param url
     */

    public static void get(String url) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream in = entity.getContent();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

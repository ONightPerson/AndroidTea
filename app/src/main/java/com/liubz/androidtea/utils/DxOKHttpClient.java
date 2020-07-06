package com.liubz.androidtea.utils;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class DxOKHttpClient {

    private static final String TAG = "DxOKHttpClient";

    static final int DOWNLOAD_BUFFER_SIZE = 32 * 1024; // 32KB

    private int mConnTimeout;  // milliseconds
    private int mReadTimeout;  // milliseconds

    private DxOKHttpClient(int connTimeOut, int readTimeOut) {
        mConnTimeout = connTimeOut;
        mReadTimeout = readTimeOut;
    }

    public static DxOKHttpClient createInstance() {
        return new DxOKHttpClient(20000, 20000);  // 20 seconds
    }

    /**
     * post 请求，依赖 okhttp 库
     * @param cxt
     * @param url
     * @param body
     * @return
     * @throws IOException
     */
    public String commonPost(Context cxt, String url, String body) throws IOException {
        OkHttpClient client = getOkHttpClient();
        if (client == null) {
            return null;
        }
        Request request = postRequest(url, body);

        // Send the "POST" request
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            // should not be here, but.....
            throw new IOException(e.toString());
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    public String commonGet(Context cxt, String url)
            throws IOException {
        OkHttpClient client = getOkHttpClient();
        if (client == null) {
            return null;
        }
        Request request = getRequest(url);

        // Send the "POST" request
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            // should not be here, but.....
            throw new IOException(e.toString());
        } finally {
            // Must be called before calling HttpURLConnection.disconnect()
            if (response != null) {
                response.close();
            }
        }
    }

    public void commonDownload(Context cxt, String url, File targetFile)
            throws IOException {
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            OkHttpClient client = getOkHttpClient();
            if (client == null) {
                return;
            }
            Request request = getRequest(url);
            Response response = client.newCall(request).execute();
            is = response.body().byteStream();

            File dirFile = targetFile.getParentFile();
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            fos = new FileOutputStream(targetFile);
            byte[] buffer = new byte[DOWNLOAD_BUFFER_SIZE];
            int len;
            while ((len = is.read(buffer)) != -1 ) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
        } catch (IOException e) {
        } finally {
            if (is != null) {
                is.close();
            }
            if (fos != null) {
                fos.close();
            }
        }

    }

    private Request getRequest(String url) {
        return request(url, null);
    }

    private Request postRequest(String url, String body) {
        return request(url, body);
    }

    private Request request(String url, String body) {
        Request.Builder builder = new Request.Builder().url(url);

        if (body != null) {
            MediaType textType = MediaType.parse("text/plain; charset=utf-8");
            RequestBody requestBody = RequestBody.create(textType, body);
            builder.post(requestBody);

        }
        CacheControl control = new CacheControl.Builder().noCache().build();
        builder.cacheControl(control);

        return builder.build();
    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder ohcBuilder = new OkHttpClient.Builder()
                .readTimeout(mReadTimeout, TimeUnit.MILLISECONDS)
                .connectTimeout(mConnTimeout, TimeUnit.MILLISECONDS);

        return ohcBuilder.build();
    }
}

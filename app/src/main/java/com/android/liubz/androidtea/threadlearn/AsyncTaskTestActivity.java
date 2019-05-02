package com.android.liubz.androidtea.threadlearn;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.android.liubz.androidtea.R;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AsyncTaskTestActivity extends Activity {
    private static final String TAG = "AsyncTaskTestActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_test);
    }

    public void download(View v) {
        new DownloadTask("DownloadTask#1").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                URI.create("https://www.mybooks/list/1"),
                URI.create("https://www.mybooks/list/2"),
                URI.create("https://www.mybooks/list/3"));

        new DownloadTask("DownloadTask#2").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                URI.create("https://www.mybooks/list/1"),
                URI.create("https://www.mybooks/list/2"),
                URI.create("https://www.mybooks/list/3"));

        new DownloadTask("DownloadTask#3").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                URI.create("https://www.mybooks/list/1"),
                URI.create("https://www.mybooks/list/2"),
                URI.create("https://www.mybooks/list/3"));
    }


    private static class DownloadTask extends AsyncTask<URI, Integer, Long> {

        private String mTaskName;

        public DownloadTask(String taskName) {
            super();
            mTaskName = taskName;
        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute: ");
        }

        @Override
        protected Long doInBackground(URI... uris) {
            int count = uris.length;
            int i = 0;
            for (URI uri : uris) {
                Log.i(TAG, "doInBackground: uri: " + uri);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                int percent = (int) ((float)i*100 / count);
                publishProgress(percent);
            }
            return 200000l;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "onProgressUpdate: values: " + values[0]);
        }

        @Override
        protected void onPostExecute(Long result) {
            Log.i(TAG, "onPostExecute: result: " + result);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            Log.e(TAG, mTaskName + " execute finish at: " + sdf.format(new Date()));
        }
    }
}

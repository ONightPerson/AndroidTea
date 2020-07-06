package com.android.liubz.androidtea.thread;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.android.liubz.androidtea.R;

import java.lang.ref.WeakReference;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AsyncTaskTestActivity extends Activity {
    private static final String TAG = "AsyncTaskTestActivity";

    private ProgressBar mProgressBar;
    private SeekBar mSeekBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_test);

        initViews();
    }

    private void initViews() {
        mProgressBar = findViewById(R.id.progress_bar);
        mSeekBar = findViewById(R.id.seek_bar);
    }

    public void download(View v) {
        new DownloadTask("DownloadTask#1", this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                URI.create("https://www.mybooks/list/1"),
                URI.create("https://www.mybooks/list/2"),
                URI.create("https://www.mybooks/list/3"));

//        new DownloadTask("DownloadTask#2").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
//                URI.create("https://www.mybooks/list/1"),
//                URI.create("https://www.mybooks/list/2"),
//                URI.create("https://www.mybooks/list/3"));
//
//        new DownloadTask("DownloadTask#3").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
//                URI.create("https://www.mybooks/list/1"),
//                URI.create("https://www.mybooks/list/2"),
//                URI.create("https://www.mybooks/list/3"));
    }


    private static class DownloadTask extends AsyncTask<URI, Integer, Long> {

        private String mTaskName;
        private WeakReference<AsyncTaskTestActivity> mRef;
        private ProgressDialog mProgressDialog;

        public DownloadTask(String taskName, AsyncTaskTestActivity activity) {
            super();
            mTaskName = taskName;
            mRef = new WeakReference<>(activity);
            activity.mProgressBar.setVisibility(View.VISIBLE);
            activity.mSeekBar.setVisibility(View.VISIBLE);
            mProgressDialog = new ProgressDialog(activity);
            mProgressDialog.show();
        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, mTaskName + " onPreExecute: ");

        }

        @Override
        protected Long doInBackground(URI... uris) {
            int count = uris.length;
            int i = 0;
            for (URI uri : uris) {
                Log.i(TAG, mTaskName + " doInBackground: uri: " + uri);
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
            Log.i(TAG, mTaskName + " onProgressUpdate: values: " + values[0]);
            AsyncTaskTestActivity activity = mRef.get();
            if (activity != null) {
                activity.mProgressBar.setProgress(values[0]);
                activity.mSeekBar.setProgress(values[0]);
                mProgressDialog.setMessage("进度: " + values[0] + "%");
            }


        }

        @Override
        protected void onPostExecute(Long result) {
            Log.i(TAG, mTaskName + " onPostExecute: result: " + result);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Log.e(TAG, mTaskName + " execute finish at: " + sdf.format(new Date()));
            AsyncTaskTestActivity activity = mRef.get();
            if (activity != null) {
                activity.mSeekBar.setVisibility(View.GONE);
                activity.mProgressBar.setVisibility(View.GONE);
                mProgressDialog.dismiss();
            }
        }
    }
}
